package cn.zhouqifun.search.dao.impl;

import cn.zhouqifun.search.dao.SearchDao;
import cn.zhouqifun.search.pojo.SearchGoods;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhouqi on 2017/5/6.
 */
@Repository
public class SearchDaoImpl implements SearchDao {

    @Autowired
    private SolrServer solrServer;

    @Override
    public List<SearchGoods> search(SolrQuery query) throws Exception {
        //执行查询
        QueryResponse response = solrServer.query(query);
        //取查询结果列表
        SolrDocumentList documentList = response.getResults();
        List<SearchGoods> goodsList = new ArrayList<>();
        for (SolrDocument solrDocument : documentList) {
            //创建一个对象SearchItem 对象
            SearchGoods goods = new SearchGoods();
            goods.setG_id(Integer.parseInt((String) solrDocument.get("id")));
            //去高亮显示
            Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
            List<String> list = highlighting.get(solrDocument.get("id")).get("goods_name");
            String goodsName = "";
            if(list != null && list.size() > 0){
                //取高亮后的结果
                goodsName = list.get(0);
            }else {
                goodsName = (String) solrDocument.get("goods_name");
            }
            goods.setG_name(goodsName);
            goods.setG_picture1((String) solrDocument.get("goods_picture1"));
            goods.setG_bargain((String) solrDocument.get("goods_bargain"));
            goods.setG_price((Long) solrDocument.get("goods_price"));
            goods.setG_place((String) solrDocument.get("goods_place"));
            //添加到列表
            goodsList.add(goods);
        }
        return goodsList;
    }
}
