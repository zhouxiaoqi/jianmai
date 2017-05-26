package cn.zhouqifun.search.pojo;

import java.util.List;

/**
 * Created by zhouqi on 2017/5/6.
 */
public class SearchResult {

    private List<SearchGoods> goodsList;
    private Long recordCount;
    private int pageCount;
    private int curpage;

    public List<SearchGoods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<SearchGoods> goodsList) {
        this.goodsList = goodsList;
    }

    public Long getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(Long recordCount) {
        this.recordCount = recordCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getCurpage() {
        return curpage;
    }

    public void setCurpage(int curpage) {
        this.curpage = curpage;
    }
}
