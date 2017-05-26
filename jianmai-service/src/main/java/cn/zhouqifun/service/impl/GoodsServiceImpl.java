package cn.zhouqifun.service.impl;

import cn.zhouqifun.mapper.GoodsDao;
import cn.zhouqifun.pojo.Goods;
import cn.zhouqifun.redis.JedisClient;
import cn.zhouqifun.service.GoodsService;
import cn.zhouqifun.util.JsonUtil;
import cn.zhouqifun.util.StringUtil;
import com.sun.org.apache.regexp.internal.RE;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhouqi on 2017/4/4.
 */
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private JedisClient jedisClient;

    @Value("${REDIS_GOODS}")
    private String REDIS_GOODS;


    @Override
    public int insertForGoods(Goods goods) {
        return goodsDao.insertForGoods(goods);
    }

    /**
     * 得到我发布过的商品
     *
     * @param a_id
     * @return
     */
    @Override
    public List<Goods> getForMyGoods(int a_id) {

        List<Goods> idList = goodsDao.getForMyGoods(a_id);
        List<Goods> goodsList = new ArrayList<>();
        for (Goods gIds : idList) {
            String json = jedisClient.hget(REDIS_GOODS, gIds.getG_id().toString());
            Goods goodsFromRedis = JsonUtil.fromJson(json, Goods.class);
            if (goodsFromRedis != null) {
                goodsList.add(goodsFromRedis);
            } else {
                Goods goodsFromDB = goodsDao.getMyGoodsPreview(gIds.getG_id());
                jedisClient.hset(REDIS_GOODS, goodsFromDB.getG_id().toString(), JsonUtil.toJson(goodsFromDB));
                goodsList.add(goodsFromDB);
            }
        }
        return goodsList;
    }

    /**
     * 得到该学校下的二手商品
     *
     * @param s_id 学校id
     * @return
     */
    @Override
    public List<Goods> getForGoodsAtSchool(int s_id, int currentPage, int pageSize) {
        //先查数据库，将需要的商品列表id（注意，只是id）查出来
        List<Goods> idList = goodsDao.getForGoodsAtSchool(s_id, (currentPage - 1) * pageSize);
        List<Goods> goodsList = RedisCommon(idList);
        return goodsList;
    }

    @Override
    public Goods getForGoodsById(int g_id) {
        return goodsDao.getForGoodsById(g_id);
    }

    @Override
    public Goods getForUpdateGoods(int g_id) {
        return goodsDao.getForUpdateGoods(g_id);
    }

    /**
     * 修改商品
     *
     * @param goods
     * @return
     */
    @Override
    public int updateForGoods(Goods goods) {
        jedisClient.hdel(REDIS_GOODS, goods.getG_id().toString());
        return goodsDao.updateForGoods(goods);
    }

    /**
     * 自行下架
     *
     * @param g_id
     * @return
     */
    @Override
    public int updateForOffGoods(int g_id) {
        jedisClient.hdel(REDIS_GOODS, g_id + "");
        return goodsDao.updateForOffGoods(g_id);
    }

    /**
     * 自行上架
     *
     * @param g_id
     * @return
     */
    @Override
    public int updateForOnGoods(int g_id) {
        jedisClient.hdel(REDIS_GOODS, g_id + "");
        return goodsDao.updateForOnGoods(g_id);
    }

    /**
     * 已售出
     *
     * @param g_id
     * @return
     */
    @Override
    public int updateForAlreadySell(int g_id) {
        jedisClient.hdel(REDIS_GOODS, g_id + "");
        return goodsDao.updateForAlreadySell(g_id);
    }

    @Override
    public List<Goods> getForGoodsInThisType(int t_id, int s_id) {
        return goodsDao.getForGoodsInThisType(t_id, s_id);
    }

    /**
     * 得到这个种类下的二手商品（不限学校）
     *
     * @param t_id
     * @return
     */
    @Override
    public List<Goods> getForAllGoodsInThisType(int t_id) {
        // 先将gid查出来，只是id
        List<Goods> idList = goodsDao.getForAllGoodsInThisType(t_id);
        List<Goods> goodsList = RedisCommon(idList);

        return goodsList;
    }

    @Override
    public List<Goods> getForOtherUserGoods(int a_id) {
        return goodsDao.getForOtherUserGoods(a_id);
    }

    @Override
    public int countForGoods(int t_id) {
        return goodsDao.countForGoods(t_id);
    }


    /**
     * Redis通用方法
     *
     * @param idList 所需的商品id列表
     *               <p>
     *               根据传进来的idList 进行遍历，根据每个id去缓存查，
     *               如果有，入goodsList，如果没有，去数据库查询,入goodsList，再放入缓存，方便下次查
     *               更细粒度的进行缓存，避免脏数据
     * @return
     */
    protected List<Goods> RedisCommon(List<Goods> idList) {

        List<Goods> goodsList = new ArrayList<>();

        for (Goods gIds : idList) {
            String json = jedisClient.hget(REDIS_GOODS, gIds.getG_id().toString());
            Goods goodsFromRedis = JsonUtil.fromJson(json, Goods.class);
            if (goodsFromRedis != null) {
                goodsList.add(goodsFromRedis);
            } else {
                Goods goodsFromDB = goodsDao.getGoodsPreview(gIds.getG_id());
                jedisClient.hset(REDIS_GOODS, goodsFromDB.getG_id().toString(), JsonUtil.toJson(goodsFromDB));
                goodsList.add(goodsFromDB);
            }
        }
        return goodsList;
    }

    @Override
    public int addBrownTimes(int g_id) {
        return goodsDao.addBrownTimes(g_id);
    }

    @Override
    public List<Goods> getRecommentGoods(int s_id) {
        return goodsDao.getRecommentGoods(s_id);
    }
}
