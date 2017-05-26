package cn.zhouqifun.search.service.impl;

import cn.zhouqifun.search.mapper.GoodsMapper;
import cn.zhouqifun.search.pojo.SearchGoods;
import cn.zhouqifun.search.service.GoodsService;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * 商品导入service
 * Created by zhouqi on 2017/5/6.
 */
@Service("goodsService")
public class GoodsServiceimpl implements GoodsService {

    @Autowired
    private SolrServer solrServer;

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public int getItemList() throws IOException, SolrServerException {
        // 查询数据库获得商品列表
        List<SearchGoods> goodsList = goodsMapper.getItemList();
        // 遍历列表
        for (SearchGoods goods : goodsList) {
            //创建文档对象
            SolrInputDocument solrInputDocument = new SolrInputDocument();
            //添加域
            solrInputDocument.addField("id",goods.getG_id().toString());
            solrInputDocument.addField("goods_name",goods.getG_name());
            solrInputDocument.addField("goods_picture1",goods.getG_picture1());
            solrInputDocument.addField("goods_price",goods.getG_price());
            solrInputDocument.addField("goods_place",goods.getG_place());
            solrInputDocument.addField("goods_bargain",goods.getG_bargain());
            // 写入索引库
            solrServer.add(solrInputDocument);
        }
        //提交
        solrServer.commit();
        return 1;
    }
}
