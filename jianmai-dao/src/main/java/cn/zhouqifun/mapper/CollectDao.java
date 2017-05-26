package cn.zhouqifun.mapper;

import cn.zhouqifun.pojo.Collect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 收藏
 * Created by zhouqi on 2017/4/7.
 */
public interface CollectDao {

    /**
     * 根据二手商品id和用户id，判断该用户是否收藏过该二手商品
     * @param g_id
     * @param a_id
     * @return
     */
    Collect getForCollectById(@Param("g_id") int g_id, @Param("a_id") int a_id);

    /**
     * 收藏二手商品
     * @param g_id
     * @param a_id
     * @return
     */
    int insertForCollect(@Param("g_id") int g_id, @Param("a_id") int a_id);


    /**
     * 取消收藏二手商品
     * @param g_id
     * @param a_id
     * @return
     */
    int deleteForCollect(@Param("g_id") int g_id,@Param("a_id") int a_id);


    /**
     * 取出我收藏的二手商品列表
     * @param a_id
     * @return
     */
    List<Collect> getMyCollectByAid(@Param("a_id") int a_id);


}
