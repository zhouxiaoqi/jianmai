package cn.zhouqifun.mapper;

import cn.zhouqifun.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;

public interface UserInfoDao {

    /**
     * 根据用户id获取个人信息
     *
     * @param a_id 用户id
     * @return 返回数据
     */
    UserInfo getForUserInfoById(@Param("a_id") int a_id);


    /**
     * 根据用户id修改个人信息
     *
     * @param my_nickname
     * @param my_phonenum
     * @param my_qq
     * @return 返回数据库影响行数
     */
    int updateForUserInfoById(
            @Param("my_nickname") String my_nickname,
            @Param("my_phonenum") String my_phonenum,
            @Param("my_qq") String my_qq,
            @Param("a_id") int a_id);


    /**
     * 根据用户id修改个人头像
     *
     * @param filePath 图片路径
     * @param a_id     用户id
     * @return 返回数据库影响行数
     */
    int updateForUserHeaderpic(@Param("filepath") String filePath, @Param("a_id") int a_id);

    /**
     * 查看其他人的信息
     * @param a_id
     * @return
     */
    UserInfo getForOtherUserInfo(@Param("a_id") int a_id);

}
