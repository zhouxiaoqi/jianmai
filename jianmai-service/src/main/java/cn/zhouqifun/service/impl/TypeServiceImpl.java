package cn.zhouqifun.service.impl;

import cn.zhouqifun.mapper.TypeDao;
import cn.zhouqifun.pojo.Type;
import cn.zhouqifun.redis.JedisClient;
import cn.zhouqifun.service.TypeService;
import cn.zhouqifun.util.JsonUtil;
import cn.zhouqifun.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhouqi on 2017/3/30.
 */
@Service("typeService")
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDao typeDao;

    @Autowired
    private JedisClient jedisClient;

    @Value("${REDIS_ALL_TYPE}")
    private String REDIS_ALL_TYPE;

    /**
     * 获取所有类别列表
     *
     * @return
     */
    @Override
    public List<Type> get_AllType() {

        // 先查redis，如果有直接返回没有再查数据库
        try {
            String json = jedisClient.get(REDIS_ALL_TYPE);
            if(!StringUtil.isEmpty(json)){
                return JsonUtil.toList(json,Type.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Type> typeList = typeDao.get_AllType();

        // 从数据库查询后放入redis缓存中
        // 这里可以不采用hash
        try {
            jedisClient.set(REDIS_ALL_TYPE, JsonUtil.toJSONString(typeList));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return typeList;
    }

    @Override
    public Type get_TypeInfoByTid(int t_id) {
        return typeDao.get_TypeInfoByTid(t_id);
    }
}
