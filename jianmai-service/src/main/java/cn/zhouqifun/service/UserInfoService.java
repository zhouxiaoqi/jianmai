package cn.zhouqifun.service;

import cn.zhouqifun.pojo.UserInfo;

public interface UserInfoService {

    /**
     * 根据用户id获取个人信息
     *
     * @param a_id 用户id
     * @return 返回数据
     */
    UserInfo getForUserInfoById(int a_id);

    /**
     * 根据用户id修改个人信息
     *
     * @param my_nickname
     * @param my_phonenum
     * @param my_qq
     * @return 返回数据库影响行数
     */
    int updateForUserInfoById(String my_nickname, String my_phonenum, String my_qq, int a_id);

    /**
     * 根据用户id修改个人头像
     *
     * @param filePath 图片路径
     * @param a_id     用户id
     * @return 返回数据库影响行数
     */
    int updateForUserHeaderpic(String filePath, int a_id);


    /**
     * 查看其他人的信息
     * @param a_id
     * @return
     */
    UserInfo getForOtherUserInfo(int a_id);

}
