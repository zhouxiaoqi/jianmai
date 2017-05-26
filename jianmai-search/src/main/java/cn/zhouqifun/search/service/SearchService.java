package cn.zhouqifun.search.service;

import cn.zhouqifun.search.pojo.SearchGoods;

import java.util.List;

/**
 * Created by zhouqi on 2017/5/6.
 */
public interface SearchService {

    List<SearchGoods> search(String queryString) throws Exception;
}
