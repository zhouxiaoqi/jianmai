package cn.zhouqifun.controller;

import cn.zhouqifun.pojo.School;
import cn.zhouqifun.service.SchoolService;
import cn.zhouqifun.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by zhouqi on 2017/3/22.
 */
@RequestMapping("/school")
@Controller
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    /**
     * 得到所有学校信息供用户选择
     * @return
     */
    @ResponseBody
    @RequestMapping("/allschool")
    public List<School> getAllSchool(){
        List<School> schools = schoolService.getAllForSchool();
        for(School school : schools){
            school.setS_badge(StringUtil.mosaicUrl(school.getS_badge()));
        }
        return schools;
    }


    /**
     * 根据id得到该学校的信息
     * @param s_id
     * @param session
     * @return
     */
    @RequestMapping("/{s_id}")
    public String getSchoolInfoById(@PathVariable("s_id") int s_id, HttpSession session){
        School choose_School = schoolService.getForChooseSchoolById(s_id);
        session.setAttribute("schoolinfo",choose_School);
        return "jsp/index";
    }




}
