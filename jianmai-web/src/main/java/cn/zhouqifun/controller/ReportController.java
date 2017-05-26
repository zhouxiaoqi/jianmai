package cn.zhouqifun.controller;

import cn.zhouqifun.pojo.Goods;
import cn.zhouqifun.pojo.Report;
import cn.zhouqifun.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhouqi on 2017/4/27.
 */
@RequestMapping("/report")
@Controller
public class ReportController {

    @Autowired
    private ReportService reportService;

    /**
     *
     * @param g_id
     * @return
     */
    @ResponseBody
    @RequestMapping("/insertreport")
    public int insertReport(int g_id) {
        Report report = new Report();
        Goods goods = new Goods();
        goods.setG_id(g_id);
        report.setGoods(goods);
        int affectRows = reportService.insertForReport(report);
        if(affectRows > 0){
            return 1;
        }else{
            return 0;
        }
    }
}
