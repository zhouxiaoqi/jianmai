package cn.zhouqifun.service.impl;

import cn.zhouqifun.mapper.SchoolDao;
import cn.zhouqifun.pojo.School;
import cn.zhouqifun.redis.JedisClient;
import cn.zhouqifun.service.SchoolService;
import cn.zhouqifun.util.JsonUtil;
import cn.zhouqifun.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhouqi on 2017/3/22.
 */
@Service("schoolService")
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolDao schoolDao;

    @Autowired
    private JedisClient jedisClient;

    @Value("${REDIS_ALL_SCHOOL}")
    private String REDIS_ALL_SCHOOL;


    /**
     * 得到所有学校
     *
     * @return
     */
    @Override
    public List<School> getAllForSchool() {

        try {
            String json = jedisClient.get(REDIS_ALL_SCHOOL);
            if (!StringUtil.isEmpty(json)) {
                return JsonUtil.toList(json, School.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<School> schoolList = schoolDao.getAllForSchool();
        try {
            jedisClient.set(REDIS_ALL_SCHOOL, JsonUtil.toJSONString(schoolList));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return schoolList;
    }

    /**
     * 根据学校id得到该学校的信息
     *
     * @param s_id
     * @return
     */
    @Override
    public School getForChooseSchoolById(int s_id) {
        return schoolDao.getForChooseSchoolById(s_id);
    }


}
