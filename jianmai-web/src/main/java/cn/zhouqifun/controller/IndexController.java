package cn.zhouqifun.controller;

import cn.zhouqifun.pojo.UserInfo;
import cn.zhouqifun.service.UserInfoService;
import cn.zhouqifun.wechat.WeChatUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.UUID;

/**
 * Created by zhouqi on 2017/3/22.
 */

@Controller
public class IndexController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 首页
     * @return
     */
    @RequestMapping("/index")
    public String index(HttpSession session){
        if(session.getAttribute("schoolinfo") == null){
            return "redirect:/";
        }
        return "jsp/index";
    }

    @RequestMapping("/forgot")
    public String forgotpassword(){
        return "jsp/getusername";
    }

    /**
     * 切换学校
     * @param session
     * @return
     */
    @RequestMapping("/school")
    public String switchSchool(HttpSession session){
        session.removeAttribute("schoolinfo");
        return "redirect:/";
    }

    @RequestMapping("/release")
    public String release(HttpSession session){
        if(session.getAttribute("userinfo") == null){
            return "redirect:/index.html";
        }else if(session.getAttribute("schoolinfo") == null){
            return "redirect:/";
        }
        return "jsp/release";
    }

    /**
     * 查看我的个人信息
     * @return
     */
    @RequestMapping("/info")
    public String myinfo() {
        return "jsp/myinfo";
    }


    /**
     * 查看其他用户的信息
     * @param a_id
     * @param request
     * @return
     */
    @RequestMapping("/otheruser/{a_id}")
    public String otherinfo(@PathVariable("a_id") int a_id,HttpServletRequest request){
        UserInfo userInfo = userInfoService.getForOtherUserInfo(a_id);
        if(userInfo == null){
            return "redirect:/error.html";
        }
        request.setAttribute("otherinfo",userInfo);
        return "jsp/otherinfo";
    }

    /**
     * 求购专区
     * @return
     */
    @RequestMapping("/want")
    public String want(){
        return "jsp/want";
    }



    /**
     * 发布成功后的跳转
     * @return
     */
    @RequestMapping("/success")
    public String success(){
        return "jsp/success";
    }

    /**
     * 服务器异常跳转页面
     * @return
     */
    @RequestMapping("/error")
    public String error(){
        return "jsp/error";
    }





    @ResponseBody
    @RequestMapping("/wechatconfig")
    public JSONObject getWechatConfig(){
        //1、获取AccessToken
        String accessToken = WeChatUtil.getAccessToken();
        //2、获取Ticket
        String jsapi_ticket = WeChatUtil.getTicket(accessToken);
        //3、时间戳和随机字符串
        String noncestr = UUID.randomUUID().toString().replace("-", "").substring(0, 16);//随机字符串
        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);//时间戳
        System.out.println("accessToken:" + accessToken + "\njsapi_ticket:" + jsapi_ticket + "\n时间戳：" + timestamp + "\n随机字符串：");
        //4、获取url
        /*String url = "http://www.luiyang.com/add.html";*/
        String[] ArrTmp = {"jsapi_ticket", "timestamp", "nonce", "url"};
        Arrays.sort(ArrTmp);
        StringBuffer sf = new StringBuffer();
        for (int i = 0; i < ArrTmp.length; i++) {
            sf.append(ArrTmp[i]);
        }
        //5、将参数排序并拼接字符串
        String str = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + noncestr + "&timestamp=" + timestamp + "&url=" + sf;
        //6、将字符串进行sha1加密
        String signature = WeChatUtil.SHA1(str);
        System.out.println("参数：" + str + "\n签名：" + signature);
        JSONObject config = new JSONObject();
        config.put("timestamp",timestamp);
        config.put("noncestr",noncestr);
        config.put("signature",signature);
        return config;
    }
}
