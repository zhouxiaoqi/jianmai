package cn.zhouqifun.service.impl;

import cn.zhouqifun.mapper.AppDao;
import cn.zhouqifun.pojo.Goods;
import cn.zhouqifun.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhouqi on 2017/5/25.
 */
@Service("appService")
public class AppServiceImpl implements AppService {

    @Autowired
    private AppDao appDao;


    @Override
    public List<Goods> getAllGoods() {
        return appDao.getAllGoods();
    }
}
