package cn.zhouqifun.mapper;

import cn.zhouqifun.pojo.Advers;

import java.util.List;

/**
 * 广告
 * Created by zhouqi on 2017/4/23.
 */
public interface AdversDao {

    /**
     * 得到所有的广告内容
     * @return
     */
    List<Advers> getForAllAdvers();
}

