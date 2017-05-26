package cn.zhouqifun.service.impl;

import cn.zhouqifun.mapper.WantDao;
import cn.zhouqifun.pojo.Want;
import cn.zhouqifun.service.WantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhouqi on 2017/4/16.
 */
@Service("wantService")
public class WantServiceImpl implements WantService {

    @Autowired
    private WantDao wantDao;

    @Override
    public int insertForWantGoods(Want want) {
        return wantDao.insertForWantGoods(want);
    }

    @Override
    public List<Want> getForMyWantGoods(int a_id) {
        return wantDao.getForMyWantGoods(a_id);
    }

    @Override
    public int updateForReGroundingWant(int w_id,int state) {
        return wantDao.updateForReGroundingWant(w_id,state);
    }

    @Override
    public Want getForWantGoodsByWid(int w_id) {
        return wantDao.getForWantGoodsByWid(w_id);
    }

    @Override
    public List<Want> getForAtSchoolGoods(int s_id) {
        return wantDao.getForAtSchoolGoods(s_id);
    }

    @Override
    public int updateForWantGoods(Want want) {
        return wantDao.updateForWantGoods(want);
    }
}
