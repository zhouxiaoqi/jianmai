package cn.zhouqifun.search.dao;

import cn.zhouqifun.search.pojo.SearchGoods;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;

import java.util.List;

/**
 * Created by zhouqi on 2017/5/6.
 */
public interface SearchDao {

    List<SearchGoods> search(SolrQuery query) throws Exception;

}
