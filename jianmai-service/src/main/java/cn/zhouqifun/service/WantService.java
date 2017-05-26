package cn.zhouqifun.service;

import cn.zhouqifun.pojo.Want;

import java.util.List;

/**
 * Created by zhouqi on 2017/4/16.
 */
public interface WantService {


    /**
     * 发布求购商品
     * @param want
     * @return
     */
    int insertForWantGoods(Want want);

    /**
     * 获取我发布过的求购商品
     * @param a_id
     * @return
     */
    List<Want> getForMyWantGoods(int a_id);

    /**
     * 重新上架或下架求购信息
     * @param w_id
     * @return
     */
    int updateForReGroundingWant(int w_id,int state);


    /**
     * 根据w_id得到求购信息
     * @param w_id
     * @return
     */
    Want getForWantGoodsByWid(int w_id);

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
    List<Want> getForAtSchoolGoods(int s_id);
}
