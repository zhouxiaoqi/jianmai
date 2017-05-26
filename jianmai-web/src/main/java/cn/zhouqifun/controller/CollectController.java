
package cn.zhouqifun.controller;

import cn.zhouqifun.pojo.Collect;
import cn.zhouqifun.pojo.UserInfo;
import cn.zhouqifun.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by zhouqi on 2017/4/7.
 */
@RequestMapping("/collect")
@Controller
public class CollectController {

    @Autowired
    private CollectService collectService;


    /**
     * 该用户是否收藏过该二手商品
     * @param session
     * @param g_id
     * @return
     */
    @ResponseBody
    @RequestMapping("/getcollect")
    public int getCollectById(HttpSession session, Integer g_id) {
        UserInfo userInfo = (UserInfo) session.getAttribute("userinfo");
        if(userInfo == null){
            return -1;
        }
        Collect collect = collectService.getForCollectById(g_id, userInfo.getAccount().getA_id());
        if (collect != null)
            return 1;
        else {
            return 0;
        }
    }

    /**
     * 收藏商品
     *
     * @param session
     * @param g_id
     * @return
     */
    @ResponseBody
    @RequestMapping("/collectgoods")
    public int Collect(HttpSession session, int g_id) {
        UserInfo userInfo = (UserInfo) session.getAttribute("userinfo");
        int affectRows = collectService.insertForCollect(g_id, userInfo.getAccount().getA_id());
        return affectRows;
    }

    /**
     * 取消收藏二手商品
     * @param session
     * @param g_id
     * @return
     */
    @ResponseBody
    @RequestMapping("/removecollect")
    public int removeCollect(HttpSession session,int g_id){
        UserInfo userInfo = (UserInfo) session.getAttribute("userinfo");
        int affectRows = collectService.deleteForCollect(g_id,userInfo.getAccount().getA_id());
        return affectRows;
    }

    /**
     * 得到用户收藏的二手商品列表
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/getmycollected")
    public List<Collect> getMyCollected(HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute("userinfo");
        List<Collect> collectList = collectService.getMyCollectByAid(userInfo.getAccount().getA_id());
        return collectList;
    }
}
