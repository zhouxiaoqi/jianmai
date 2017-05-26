package cn.zhouqifun.service.impl;

import cn.zhouqifun.mapper.SellCountDao;
import cn.zhouqifun.service.SellScountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhouqi on 2017/4/13.
 */
@Service("sellCountService")
public class SellCountServiceImpl implements SellScountService {

    @Autowired
    private SellCountDao sellCountDao;


    @Override
    public int countInTheSchoolForHelp(int s_id) {
        return sellCountDao.countInTheSchoolForHelp(s_id);
    }

    @Override
    public int updateForAddCount(int s_id) {
        return sellCountDao.updateForAddCount(s_id);
    }
}
