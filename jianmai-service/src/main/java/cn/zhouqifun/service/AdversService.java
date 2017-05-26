package cn.zhouqifun.service;

import cn.zhouqifun.pojo.Advers;

import java.util.List;

/**
 * Created by zhouqi on 2017/4/23.
 */
public interface AdversService {

    /**
     * 得到所有的广告内容
     * @return
     */
    List<Advers> getForAllAdvers();
}
