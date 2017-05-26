package cn.zhouqifun.mapper;

import cn.zhouqifun.pojo.Type;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 类别
 * Created by zhouqi on 2017/3/30.
 */
public interface TypeDao {

    /**
     * 获取种类列表在首页显示
     * @return
     */
    List<Type> get_AllType();


    /**
     * 获取该种类的详细信息
     * @param t_id
     * @return
     */
    Type get_TypeInfoByTid(@Param("t_id") int t_id);

}
