package cn.zhouqifun.controller;

import cn.zhouqifun.pojo.UserInfo;
import cn.zhouqifun.util.StringUtil;
import com.fasterxml.jackson.databind.util.JSONPObject;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by zhouqi on 2017/4/2.
 */
@RequestMapping("/gd")
@Controller
public class GoodsDetailController {

    /**
     * 网易云单点登陆返回json
     *
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/getuinfo")
    public JSONPObject forcomment(HttpSession session, String callback) {
        UserInfo userInfo = (UserInfo) session.getAttribute("userinfo");
        JSONObject info = new JSONObject();
        if (userInfo == null) {
            info.put("isLogin", 0);
        } else {
            info.put("isLogin", 1);
            info.put("avatar",userInfo.getU_headerpic());
            info.put("nickName",userInfo.getAccount().getNickname());
            info.put("userId",userInfo.getAccount().getA_id());
        }

        return new JSONPObject(callback,info);
    }
}
