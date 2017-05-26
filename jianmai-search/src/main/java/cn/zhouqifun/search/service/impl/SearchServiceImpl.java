package cn.zhouqifun.search.service.impl;

import cn.zhouqifun.search.dao.SearchDao;
import cn.zhouqifun.search.pojo.SearchGoods;
import cn.zhouqifun.search.service.SearchService;
import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhouqi on 2017/5/6.
 */
@Service("searchService")
public class SearchServiceImpl implements SearchService{

    @Autowired
    private SearchDao searchDao;

    @Override
    public List<SearchGoods> search(String queryString) throws Exception {
        //创建查询条件
        SolrQuery query = new SolrQuery();
        //设置查询条件
        query.setQuery(queryString);
        //设置默认搜索域
        query.set("df","goods_name");
        //设置高亮
        query.setHighlight(true);
        query.addHighlightField("goods_name");
        query.setHighlightSimplePre("<font style=\"color:red;\">");
        query.setHighlightSimplePost("</font>");
        //执行查询
        List<SearchGoods> goodsList = searchDao.search(query);
        return goodsList;
    }
}
