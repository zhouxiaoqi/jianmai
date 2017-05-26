package cn.zhouqifun.solrj;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

/**
 * Created by zhouqi on 2017/5/6.
 */
public class SolrjTest {

  /*  @Test
    public void testSolrJ() throws Exception{

        //创建连接
       HttpSolrServer solrServer = new HttpSolrServer("http://123.207.107.198:8080/solr");

       // 创建一个文档对象
        SolrInputDocument document = new SolrInputDocument();
        // 添加域
        document.addField("id","solrtest01");
        document.addField("goods_name","测试商品");
        document.addField("goods_desc","测试商品描述");

        // 添加到索引库
        solrServer.add(document);

        //提交
        solrServer.commit();
    }

    @Test
    public void searchTestQuery() throws Exception{
        //创建连接
        HttpSolrServer solrServer = new HttpSolrServer("http://123.207.107.198:8080/solr");

        //创建一个查询对象
        SolrQuery query = new SolrQuery();
        query.setQuery("*:*");
        //执行查询
        QueryResponse queryResponse = solrServer.query(query);
        //取查询结果
        SolrDocumentList solrDocumentList = queryResponse.getResults();
        for (SolrDocument solrDocument:solrDocumentList) {
            System.out.println(solrDocument.get("id"));
            System.out.println(solrDocument.get("goods_name"));
            System.out.println(solrDocument.get("goods_desc"));
        }
    }*/
}
