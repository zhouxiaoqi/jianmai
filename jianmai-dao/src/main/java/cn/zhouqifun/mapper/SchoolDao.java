package cn.zhouqifun.mapper;

import cn.zhouqifun.pojo.School;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 关于学校
 * Created by zhouqi on 2017/3/22.
 */
public interface SchoolDao {

    /**
     * 取出所有学校信息列表
     * @return
     */
    List<School> getAllForSchool();


    /**
     * 选择学校，根据id取出学校信息
     * @param s_id
     * @return
     */
    School getForChooseSchoolById(@Param("s_id") int s_id);
}
