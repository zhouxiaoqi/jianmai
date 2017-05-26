package cn.zhouqifun.controller;

import cn.zhouqifun.mail.SendUpdatePasswordMail;
import cn.zhouqifun.pojo.Account;
import cn.zhouqifun.pojo.UserInfo;
import cn.zhouqifun.service.AccountService;
import cn.zhouqifun.service.UserInfoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.zhouqifun.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhouqi on 2017/3/19.
 */
@RequestMapping("/account")
@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserInfoService userInfoService;


    /**
     * 注册
     * 注册后数据库触发器插入一条默认用户个人信息
     *
     * @param account
     */
    @ResponseBody
    @RequestMapping("/regist")
    public int registAccount(Account account, HttpSession session) {
        int result = accountService.insertForRegist(account);
        if (result > 0) {
            UserInfo userInfo = userInfoService.getForUserInfoById(account.getA_id());
            session.setAttribute("userinfo", userInfo);
            return 1;
        }
        return 0;
    }

    /**
     * 登陆
     *
     * @param email
     * @param password
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/login")
    public int loginAccount(String email, String password, HttpSession session) {
        Account account = accountService.getForLogin(email, password);
        if (account == null) {
            return 0;        //为空表示没有这个用户，直接返回
        }
        UserInfo userInfo = userInfoService.getForUserInfoById(account.getA_id());
        session.setAttribute("userinfo", userInfo);
        return 1;
    }


    /**
     * 验证该邮箱是否可用
     *
     * @param email
     * @return
     */
    @ResponseBody
    @RequestMapping("/validate")
    public int validateEmail(String email) {
        String result = accountService.getForValidateEmail(email);
        if (result == null)
            return 1;
        return 0;
    }

    /**
     * 退出登陆
     *
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("userinfo");
        return "redirect:/index.html";
    }


    @RequestMapping("/sendmail")
    public String getusername(String email) throws Exception {
        String result = accountService.getForValidateEmail(email);
        if (result == null) {
            return "jsp/senderror";
        } else {
            String md5Email = MD5Util.string2MD5(email);
            String emailMd5 = email + "_" + md5Email;
            String sendContent = "<p>http://localhost:8020/account/updatepassword/" + emailMd5 + ".html</p>";
            SendUpdatePasswordMail.sendToEmail(email, sendContent);
            return "jsp/sendsuccess";
        }
    }

    @RequestMapping("/updatepassword/{emailAndMD5}")
    public String updatePasswordPage(@PathVariable("emailAndMD5") String emailAndMD5, HttpServletRequest request) {
        String[] strings = emailAndMD5.split("_");
        if (MD5Util.string2MD5(strings[0]).equals(strings[1])) {
            request.setAttribute("email", strings[0]);
            return "jsp/updatepass";
        } else {
            return "jsp/senderror";
        }
    }

    @ResponseBody
    @RequestMapping("/updatepass")
    public int updatePassword(Account account){
        return accountService.updateForpassword(account);
    }
}
