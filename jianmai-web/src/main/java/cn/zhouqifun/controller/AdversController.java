package cn.zhouqifun.controller;

import cn.zhouqifun.pojo.Advers;
import cn.zhouqifun.service.AdversService;
import cn.zhouqifun.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zhouqi on 2017/4/23.
 */
@RequestMapping("/advers")
@Controller
public class AdversController {

    @Autowired
    private AdversService adversService;

    @ResponseBody
    @RequestMapping("/getall")
    public List<Advers> getAllAdvers() {
        List<Advers> adversList = adversService.getForAllAdvers();
        for(Advers advers : adversList){
            advers.setAd_image(StringUtil.mosaicUrl(advers.getAd_image()));
        }
        return adversList;
    }
}
