package cn.zhouqifun.mapper;

import org.apache.ibatis.annotations.Param;

/**
 *
 * Created by zhouqi on 2017/4/13.
 */
public interface SellCountDao {

    /**
     * 将把该学校成功售出的次数+1
     * @param s_id
     * @return 返回数据库影响行数
     */
    int updateForAddCount(@Param("s_id") int s_id);


    /**
     * 我们帮助 ? 闲置物品找到了新主人  （统计在首页）
     * @param s_id
     * @return
     */
    int countInTheSchoolForHelp(@Param("s_id") int s_id);
}
