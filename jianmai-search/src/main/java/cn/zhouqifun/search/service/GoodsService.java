package cn.zhouqifun.search.service;

import cn.zhouqifun.search.pojo.SearchGoods;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;
import java.util.List;

/**
 * Created by zhouqi on 2017/5/6.
 */
public interface GoodsService {

    int getItemList() throws IOException, SolrServerException;
}
