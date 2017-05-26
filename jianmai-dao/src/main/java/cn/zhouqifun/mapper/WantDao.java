package cn.zhouqifun.mapper;

import cn.zhouqifun.pojo.Want;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 求购
 * Created by zhouqi on 2017/4/16.
 */
public interface WantDao {

    /**
     * 发布求购商品
     *
     * @param want
     * @return
     */
    int insertForWantGoods(Want want);


    /**
     * 获取我发布过的求购商品
     *
     * @param a_id
     * @return
     */
    List<Want> getForMyWantGoods(@Param("a_id") int a_id);


    /**
     * 重新上架或下架求购信息
     * @param w_id
     * @param state
     * @return
     */
    int updateForReGroundingWant(@Param("w_id") int w_id,@Param("state") int state);


    /**
     * 根据w_id得到求购信息
     * @param w_id
     * @return
     */
    Want getForWantGoodsByWid(@Param("w_id") int w_id);

    /**
     * 根据w_id修改我的求购信息
     * @param want
     * @return
     */
    int updateForWantGoods(Want want);


    /**
     * 获取该学校下的求购信息
     * @param s_id
     * @return
     */
    List<Want> getForAtSchoolGoods(@Param("s_id") int s_id);

}
