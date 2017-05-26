package cn.zhouqifun.controller;

import cn.zhouqifun.pojo.Type;
import cn.zhouqifun.service.TypeService;
import cn.zhouqifun.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by zhouqi on 2017/3/30.
 */
@RequestMapping("/type")
@Controller
public class TypeController {

    @Autowired
    private TypeService typeService;

    /**
     * 获取所有种类信息
     * @return
     */
    @ResponseBody
    @RequestMapping("/gettypes")
    public List<Type> getAllType(){
        List<Type> types = typeService.get_AllType();
        for(Type type : types){
            type.setT_typeimgforpc(StringUtil.mosaicUrl(type.getT_typeimgforpc()));
            type.setT_typeimgforphone(StringUtil.mosaicUrl(type.getT_typeimgforphone()));
        }
        return types;
    }


    /**
     * 获取该种类下的详细信息（比如注意事项之类）
     * @param t_id
     * @param request
     * @return
     */
    @RequestMapping("/typeinfo/{t_id}")
    public String getTypeInfo(@PathVariable("t_id") int t_id, HttpServletRequest request){
        Type type = typeService.get_TypeInfoByTid(t_id);
        type.setT_typeimgforpc(StringUtil.mosaicUrl(type.getT_typeimgforpc()));
        request.setAttribute("type",type);
        return "jsp/typeinfo";
    }

}
