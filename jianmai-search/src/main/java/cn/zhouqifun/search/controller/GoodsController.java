package cn.zhouqifun.search.controller;

import cn.zhouqifun.search.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * 导入商品数据
 * Created by zhouqi on 2017/5/6.
 */
@Controller
public class GoodsController {

    @Autowired
    private GoodsService goodsService;


    @RequestMapping("/importall")
    @ResponseBody
    public int importAll() {
        try {
            int result = goodsService.getItemList();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
