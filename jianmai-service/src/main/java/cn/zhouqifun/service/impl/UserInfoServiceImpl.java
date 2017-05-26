package cn.zhouqifun.service.impl;

import cn.zhouqifun.mapper.UserInfoDao;
import cn.zhouqifun.pojo.UserInfo;
import cn.zhouqifun.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {


    @Autowired
    private UserInfoDao userInfoDao;

    //根据id获取用户个人id
    @Override
    public UserInfo getForUserInfoById(int a_id) {
        return userInfoDao.getForUserInfoById(a_id);
    }

    // 根据id更新用户个人信息
    @Override
    public int updateForUserInfoById(String my_nickname, String my_phonenum, String my_qq, int a_id) {
        return userInfoDao.updateForUserInfoById(my_nickname, my_phonenum, my_qq, a_id);
    }

    // 根据id更新用户个人头像
    @Override
    public int updateForUserHeaderpic(String filePath, int a_id) {
        return userInfoDao.updateForUserHeaderpic(filePath, a_id);
    }

    //根据id获取其他用户的信息
    @Override
    public UserInfo getForOtherUserInfo(int a_id) {
        return userInfoDao.getForOtherUserInfo(a_id);
    }


}
