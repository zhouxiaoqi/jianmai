package cn.zhouqifun.service;

import cn.zhouqifun.pojo.Type;

import java.util.List;

/**
 * Created by zhouqi on 2017/3/30.
 */
public interface TypeService {

    /**
     * 获取种类列表在首页显示
     *
     * @return
     */
    List<Type> get_AllType();


    /**
     * 获取该种类的详细信息
     * @param t_id
     * @return
     */
    Type get_TypeInfoByTid(int t_id);
}
