package cn.zhouqifun.controller;

import cn.zhouqifun.pojo.School;
import cn.zhouqifun.service.GoodsService;
import cn.zhouqifun.service.SellScountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by zhouqi on 2017/4/13.
 */
@RequestMapping("/sellcount")
@Controller
public class SellCountController {

    @Autowired
    private SellScountService sellScountService;

    @Autowired
    private GoodsService goodsService;

    /**
     * 如果售出成功，将该商品状态改变，并将在该学校下面的售出统计 + 1
     *
     * @param session
     * @return 返回数据库影响行数
     */
    @ResponseBody
    @RequestMapping("/addcount")
    public int addCount(HttpSession session, int g_id) {
        int affectRows; //数据库影响行数变量
        School school = (School) session.getAttribute("schoolinfo");
        affectRows = goodsService.updateForAlreadySell(g_id);
        if (affectRows < 0) {
            return -1;
        } else {
            affectRows = sellScountService.updateForAddCount(school.getS_id());
            return affectRows;
        }
    }

    @ResponseBody
    @RequestMapping("/counthelp")
    public int countHelp(HttpSession session) {
        School school = (School) session.getAttribute("schoolinfo");
        int count = sellScountService.countInTheSchoolForHelp(school.getS_id());
        return count;
    }
}
