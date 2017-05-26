package cn.zhouqifun.controller;

import cn.zhouqifun.pojo.School;
import cn.zhouqifun.pojo.UserInfo;
import cn.zhouqifun.pojo.Want;
import cn.zhouqifun.service.WantService;
import cn.zhouqifun.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 求购专区
 * Created by zhouqi on 2017/4/16.
 */

@RequestMapping("/want")
@Controller
public class WantController {


    @Autowired
    private WantService wantService;

    /**
     * 进入发布页面
     *
     * @param session
     * @return
     */
    @RequestMapping("/release")
    public String releaseWant(HttpSession session) {
        UserInfo userInfo = (UserInfo) session.getAttribute("userinfo");
        if (userInfo == null) {
            return "redirect:/error.html";
        } else {
            return "jsp/releasewant";
        }
    }

    /**
     * 发布求购商品
     *
     * @param session
     * @param want
     * @return
     */
    @RequestMapping("/insertwant")
    public String insertWant(HttpSession session, Want want) {
        School school = (School) session.getAttribute("schoolinfo");
        UserInfo userInfo = (UserInfo) session.getAttribute("userinfo");
        want.setSchool(school);
        want.setAccount(userInfo.getAccount());
        int affectRows = wantService.insertForWantGoods(want);
        if (affectRows > 0) {
            return "redirect:/success.html";
        } else {
            return "redirect:/error.html";
        }
    }

    /**
     * 得到我发布过的求购信息
     *
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/getmywant")
    public List<Want> getMyWantGoods(HttpSession session) {
        UserInfo userInfo = (UserInfo) session.getAttribute("userinfo");
        return wantService.getForMyWantGoods(userInfo.getAccount().getA_id());
    }

    /**
     * 用户自行上架或下架求购信息
     *
     * @param w_id
     * @return
     */
    @ResponseBody
    @RequestMapping("/regrounding")
    public int reGroundingWant(int w_id, int state) {
        return wantService.updateForReGroundingWant(w_id, state);
    }

    /**
     * 取出该求购信息传入修改页面便于修改
     *
     * @param w_id
     * @param session
     * @param request
     * @return
     */
    @RequestMapping("/update/{w_id}")
    public String getSingleWant(@PathVariable("w_id") int w_id, HttpSession session, HttpServletRequest request) {
        UserInfo userInfo = (UserInfo) session.getAttribute("userinfo");
        Want want = wantService.getForWantGoodsByWid(w_id);
        if (userInfo.getAccount().getA_id() != want.getAccount().getA_id()) {
            return "redirect:/error.html";
        } else {
            request.setAttribute("wantinfo", want);
            return "jsp/releasewant";
        }
    }


    /**
     * 修改我发布过的求购信息
     *
     * @param want
     * @return
     */
    @RequestMapping("/updatewant")
    public String updateWant(Want want) {
        int affectRows = wantService.updateForWantGoods(want);
        if (affectRows > 0) {
            return "redirect:/success.html";
        } else {
            return "redirect:/error.html";
        }
    }

    @ResponseBody
    @RequestMapping("/getwants")
    public List<Want> getWants(HttpSession session) {
        School school = (School) session.getAttribute("schoolinfo");
        List<Want> wantList = wantService.getForAtSchoolGoods(school.getS_id());
        for (Want w : wantList) {
            w.getSchool().setS_badge(StringUtil.mosaicUrl(w.getSchool().getS_badge()));
        }
        return wantList;
    }


}
