package cn.zhouqifun.service;

import cn.zhouqifun.pojo.School;

import java.util.List;

/**
 * Created by zhouqi on 2017/3/22.
 */
public interface SchoolService {

    /**
     * 取出所有学校列表
     * @return
     */
    List<School> getAllForSchool();

    /**
     * 选择学校，根据id取出学校信息
     * @param s_id
     * @return
     */
    School getForChooseSchoolById(int s_id);
}
