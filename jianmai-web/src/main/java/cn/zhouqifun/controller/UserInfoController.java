package cn.zhouqifun.controller;

import cn.zhouqifun.pojo.UserInfo;
import cn.zhouqifun.service.UserInfoService;
import cn.zhouqifun.util.UploadFileUtil;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by zhouqi on 2017/3/19.
 */
@RequestMapping("/info")
@Controller
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;



    /**
     * 获取用户个人信息
     * 先判断session是否过期
     *
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/getmyinfo")
    public UserInfo getMyInfo(HttpSession session) {
        // 判断session是否过期
        UserInfo userInfo = (UserInfo) session.getAttribute("userinfo");
        if (userInfo == null) {
            return null;
        }
        // 没过期根据session的account_id取出个人信息返回json
        userInfo = userInfoService.getForUserInfoById(userInfo.getAccount().getA_id());
        return userInfo;
    }

    /**
     * 修改用户个人信息
     *
     * @param my_nickname 输入的昵称
     * @param my_phonenum 输入的手机号码
     * @param my_qq       输入的qq
     * @param session
     * @return 返回修改后的用户个人信息
     */
    @ResponseBody
    @RequestMapping("/update")
    public UserInfo updateMyInfo(String my_nickname, String my_phonenum, String my_qq, HttpSession session) {
        UserInfo userinfo = (UserInfo) session.getAttribute("userinfo");
        if (userinfo == null) {
            return userinfo;
        }
        int result = userInfoService.updateForUserInfoById(my_nickname, my_phonenum, my_qq, userinfo.getAccount().getA_id());
        //大于0 数据库数据修改成功
        if (result > 0) {
            //修改之后根据session里面的id再取一次便于更新渲染
            userinfo = userInfoService.getForUserInfoById(userinfo.getAccount().getA_id());
        }
        return userinfo;
    }

    /**
     * 修改用户个人头像
     *
     * @param file
     * @param request
     * @param session
     */
    @ResponseBody
    @RequestMapping("/updatemyheader")
    public int updateMyHeader(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpSession session) {
        UserInfo session_userinfo = (UserInfo) session.getAttribute("userinfo");
        if (session_userinfo == null) {
            return -1;
        }
        //String image_Name = file.getOriginalFilename().split("\\.")[0];
        String ext_Name = file.getOriginalFilename().split("\\.")[1];
        byte[] bytes = null;
        try {
            bytes = file.getBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String imagePath = UploadFileUtil.UploadFile(bytes, ext_Name);

        int result = userInfoService.updateForUserHeaderpic(imagePath,session_userinfo.getAccount().getA_id());
        if(result > 0){
            UserInfo userInfo = userInfoService.getForUserInfoById(session_userinfo.getAccount().getA_id());
            session_userinfo.setU_headerpic(userInfo.getU_headerpic());
            return 1;
        }
        return 0;
    }
}
