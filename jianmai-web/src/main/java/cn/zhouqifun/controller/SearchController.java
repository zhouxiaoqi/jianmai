package cn.zhouqifun.controller;

import cn.zhouqifun.pojo.SearchGoods;
import cn.zhouqifun.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by zhouqi on 2017/5/6.
 */
@Controller
public class SearchController {


    @Autowired
    private SearchService searchService;

    @RequestMapping("/search/q")
    public String search(@RequestParam("keyword") String keyword, Model model) {
        try {
            keyword = new String(keyword.getBytes("iso8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            keyword = "";
            e.printStackTrace();
        }
        List<SearchGoods> goodsList = searchService.search(keyword);
        for (SearchGoods goods : goodsList) {
            System.out.println(goods.getG_name().length());
        }
        model.addAttribute("query", keyword);
        model.addAttribute("goodsList", goodsList);
        model.addAttribute("searchCount", goodsList.size());
        return "jsp/searchresult";
    }
}
