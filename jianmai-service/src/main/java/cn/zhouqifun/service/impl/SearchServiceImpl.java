package cn.zhouqifun.service.impl;

import cn.zhouqifun.pojo.SearchGoods;
import cn.zhouqifun.service.SearchService;
import cn.zhouqifun.util.HttpClientUtil;
import cn.zhouqifun.util.JsonUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhouqi on 2017/5/6.
 */
@Service("searchService")
public class SearchServiceImpl implements SearchService {


    @Value("${SEARCH_BASE_URL}")
    private String SEARCH_BASE_URL;

    @Override
    public List<SearchGoods> search(String keyword) {
        //调用服务查询商品列表
        Map<String,String> param = new HashMap<>();
        param.put("keyword",keyword);
        //调用服务
        String json = HttpClientUtil.doGet(SEARCH_BASE_URL, param);

        //转换成java对象
        List<SearchGoods> goodsList = JsonUtil.toList(json,SearchGoods.class);
        return goodsList;
    }
}
