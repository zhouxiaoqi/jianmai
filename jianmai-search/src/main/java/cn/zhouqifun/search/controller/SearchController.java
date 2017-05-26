package cn.zhouqifun.search.controller;

import cn.zhouqifun.search.pojo.SearchGoods;
import cn.zhouqifun.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * 发布搜索服务
 * Created by zhouqi on 2017/5/6.
 */
@Controller
public class SearchController {

    @Autowired
    private SearchService searchService;

    @RequestMapping("/q")
    @ResponseBody
    public List<SearchGoods> search(@RequestParam(defaultValue = "") String keyword) {
        try {
            //转换字符集
            keyword = new String(keyword.getBytes("iso8859-1"),"utf-8");
            List<SearchGoods> goodsList = searchService.search(keyword);
            return goodsList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
