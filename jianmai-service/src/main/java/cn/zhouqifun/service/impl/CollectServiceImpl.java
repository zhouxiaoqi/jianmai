package cn.zhouqifun.service.impl;

import cn.zhouqifun.mapper.CollectDao;
import cn.zhouqifun.pojo.Collect;
import cn.zhouqifun.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhouqi on 2017/4/7.
 */
@Service("collectService")
public class CollectServiceImpl implements CollectService {

    @Autowired
    private CollectDao collectDao;


    @Override
    public Collect getForCollectById(int g_id, int a_id) {
        return collectDao.getForCollectById(g_id, a_id);
    }

    @Override
    public int insertForCollect(int g_id, int a_id) {
        return collectDao.insertForCollect(g_id, a_id);
    }

    @Override
    public int deleteForCollect(int g_id, int a_id) {
        return collectDao.deleteForCollect(g_id, a_id);
    }

    @Override
    public List<Collect> getMyCollectByAid(int a_id) {
        return collectDao.getMyCollectByAid(a_id);
    }


}
