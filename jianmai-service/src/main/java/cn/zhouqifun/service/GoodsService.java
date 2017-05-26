package cn.zhouqifun.service;

import cn.zhouqifun.pojo.Goods;

import java.util.List;

/**
 * Created by zhouqi on 2017/4/4.
 */
public interface GoodsService {
    /**
     * 发布商品信息
     *
     * @param goods
     * @return int:数据库影响行数
     */
    int insertForGoods(Goods goods);


    /**
     * 得到我发布的商品
     *
     * @param a_id
     * @return
     */
    List<Goods> getForMyGoods(int a_id);


    /**
     * 得到该学校下的所有二手商品
     *
     * @param s_id 学校id
     * @return
     */
    List<Goods> getForGoodsAtSchool(int s_id, int currentPage, int pageSize);


    /**
     * 根据二手商品id取得该二手商品具体信息
     *
     * @param g_id
     * @return
     */
    Goods getForGoodsById(int g_id);

    /**
     * 获取二手商品传入修改页面
     *
     * @param g_id
     * @return
     */
    Goods getForUpdateGoods(int g_id);

    /**
     * 修改个人发布过的二手商品
     *
     * @param goods
     * @return
     */
    int updateForGoods(Goods goods);

    /**
     * 用户自行下架二手商品
     *
     * @param g_id
     * @return
     */
    int updateForOffGoods(int g_id);

    /**
     * 用户自行上架二手商品
     *
     * @param g_id
     * @return
     */
    int updateForOnGoods(int g_id);

    /**
     * 如果成功售出，将物品状态改为 3：已售出
     *
     * @param g_id
     * @return
     */
    int updateForAlreadySell(int g_id);

    /**
     * 取出该类型和该学校下的所有商品
     *
     * @param t_id
     * @return
     */
    List<Goods> getForGoodsInThisType(int t_id, int s_id);


    /**
     * 取出该类别下所有的商品
     *
     * @param t_id
     * @return
     */
    List<Goods> getForAllGoodsInThisType(int t_id);

    /**
     * 得到某一用户正在出售的二手商品列表
     *
     * @param a_id
     * @return
     */
    List<Goods> getForOtherUserGoods(int a_id);

    /**
     * 统计该校下与该种类下二手商品的个数
     *
     * @param t_id
     * @return
     */
    int countForGoods(int t_id);

    /**
     * 浏览次数+1
     *
     * @param g_id
     * @return
     */
    int addBrownTimes(int g_id);

    /**
     * 得到推荐商品
     *
     * @param s_id
     * @return
     */
    List<Goods> getRecommentGoods(int s_id);


}
