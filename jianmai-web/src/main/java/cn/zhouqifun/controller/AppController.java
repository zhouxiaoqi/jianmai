package cn.zhouqifun.controller;

import cn.zhouqifun.pojo.Goods;
import cn.zhouqifun.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by zhouqi on 2017/5/25.
 */
@RequestMapping("/api")
@Controller
public class AppController {

    @Autowired
    private AppService appService;

    @ResponseBody
    @RequestMapping("/getGoods")
    public List<Goods> getAllGoods(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        return appService.getAllGoods();
    }
}
