package cn.zhouqifun.service.impl;

import cn.zhouqifun.mapper.AdversDao;
import cn.zhouqifun.pojo.Advers;
import cn.zhouqifun.redis.JedisClient;
import cn.zhouqifun.service.AdversService;
import cn.zhouqifun.util.JsonUtil;
import cn.zhouqifun.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhouqi on 2017/4/23.
 */
@Service("adversService")
public class AdversServiceImpl implements AdversService{

    @Autowired
    private AdversDao adversDao;

    @Autowired
    private JedisClient jedisClient;

    @Value("${REDIS_ADVER_CONTENT}")
    private String REDIS_ADVER_CONTENT;

    @Override
    public List<Advers> getForAllAdvers() {
        // 获取之前先去缓存redis查询.如果存在，直接返回
        try {
            String json = jedisClient.get(REDIS_ADVER_CONTENT);
            if(!StringUtil.isEmpty(json)){
                return JsonUtil.toList(json,Advers.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //如果没有，就从数据库查
        List<Advers> adversList = adversDao.getForAllAdvers();
        //查出来后放入redis缓存中，方便下次查询
        try {
            jedisClient.set(REDIS_ADVER_CONTENT,JsonUtil.toJSONString(adversList));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return adversList;
    }
}
