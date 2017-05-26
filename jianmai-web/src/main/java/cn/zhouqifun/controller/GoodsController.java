package cn.zhouqifun.controller;

import cn.zhouqifun.pojo.Goods;
import cn.zhouqifun.pojo.School;
import cn.zhouqifun.pojo.Type;
import cn.zhouqifun.pojo.UserInfo;
import cn.zhouqifun.service.GoodsService;
import cn.zhouqifun.service.TypeService;
import cn.zhouqifun.util.StringUtil;
import cn.zhouqifun.util.UploadFileUtil;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhouqi on 2017/4/4.
 */
@RequestMapping("/goods")
@Controller
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private TypeService typeService;

    /**
     * 新增商品
     *
     * @param goods
     */
    @RequestMapping("/insertgoods")
    public String insertGoods(Goods goods,
                              HttpSession session,
                              @RequestParam("picture1") MultipartFile picture1,
                              @RequestParam("picture2") MultipartFile picture2,
                              @RequestParam("picture3") MultipartFile picture3,
                              @RequestParam("picture4") MultipartFile picture4) throws Exception {
        UserInfo userInfo = (UserInfo) session.getAttribute("userinfo");
        School school = (School) session.getAttribute("schoolinfo");
        goods.setAccount(userInfo.getAccount());                            // 发布的user
        goods.setSchool(school);                                            // 属于哪个学校
        String ext_Name;
        byte[] bytes = null;
        if (StringUtil.isNotEmpty(picture1.getOriginalFilename())) {              //第一张
            ext_Name = picture1.getOriginalFilename().split("\\.")[1];
            bytes = picture1.getBytes();
            String picturePath = UploadFileUtil.UploadFile(bytes, ext_Name);
            goods.setG_picture1(picturePath);
        }
        if (StringUtil.isNotEmpty(picture2.getOriginalFilename())) {              //第二张
            ext_Name = picture2.getOriginalFilename().split("\\.")[1];
            bytes = picture2.getBytes();
            String picturePath = UploadFileUtil.UploadFile(bytes, ext_Name);
            goods.setG_picture2(picturePath);
        }
        if (StringUtil.isNotEmpty(picture3.getOriginalFilename())) {              //第三张
            ext_Name = picture3.getOriginalFilename().split("\\.")[1];
            bytes = picture3.getBytes();
            String picturePath = UploadFileUtil.UploadFile(bytes, ext_Name);
            goods.setG_picture3(picturePath);
        }
        if (StringUtil.isNotEmpty(picture4.getOriginalFilename())) {              //第四张
            ext_Name = picture4.getOriginalFilename().split("\\.")[1];
            bytes = picture4.getBytes();
            String picturePath = UploadFileUtil.UploadFile(bytes, ext_Name);
            goods.setG_picture4(picturePath);
        }
        String explain = "<p>联系我时，请说明是在『简买网』上看到的哦</p>";
        goods.setG_desc(goods.getG_desc() + explain);
        int affectRows = goodsService.insertForGoods(goods);
        if (affectRows > 0) {
            return "redirect:/success.html";
        } else {
            return "redirect:/error.html";
        }
    }


    /**
     * 修改商品
     *
     * @param goods
     * @param picture1
     * @param picture2
     * @param picture3
     * @param picture4
     * @return
     * @throws IOException
     */
    @RequestMapping("/updategoods")
    public String updateGoods(Goods goods,
                              @RequestParam("picture1") MultipartFile picture1,
                              @RequestParam("picture2") MultipartFile picture2,
                              @RequestParam("picture3") MultipartFile picture3,
                              @RequestParam("picture4") MultipartFile picture4) throws IOException {
        String ext_Name;
        byte[] bytes = null;
        if (StringUtil.isNotEmpty(picture1.getOriginalFilename())) {               // 第一张
            ext_Name = picture1.getOriginalFilename().split("\\.")[1];
            bytes = picture1.getBytes();
            String picturePath = UploadFileUtil.UploadFile(bytes, ext_Name);
            goods.setG_picture1(picturePath);
        }
        if (StringUtil.isNotEmpty(picture2.getOriginalFilename())) {              //第二张
            ext_Name = picture2.getOriginalFilename().split("\\.")[1];
            bytes = picture2.getBytes();
            String picturePath = UploadFileUtil.UploadFile(bytes, ext_Name);
            goods.setG_picture2(picturePath);
        }
        if (StringUtil.isNotEmpty(picture3.getOriginalFilename())) {              //第三张
            ext_Name = picture3.getOriginalFilename().split("\\.")[1];
            bytes = picture3.getBytes();
            String picturePath = UploadFileUtil.UploadFile(bytes, ext_Name);
            goods.setG_picture3(picturePath);
        }
        if (StringUtil.isNotEmpty(picture4.getOriginalFilename())) {              //第四张
            ext_Name = picture4.getOriginalFilename().split("\\.")[1];
            bytes = picture4.getBytes();
            String picturePath = UploadFileUtil.UploadFile(bytes, ext_Name);
            goods.setG_picture4(picturePath);
        }

        int affectRows = goodsService.updateForGoods(goods);
        if (affectRows > 0) {
            return "redirect:/success.html";
        } else {
            return "redirect:/error.html";
        }
    }

    /**
     * 得到所有类型返回显示给select框
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/gettypes")
    public List<Type> getTypes() {
        List<Type> types = typeService.get_AllType();
        return types;
    }


    /**
     * 得到我发布的商品
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/getmygoods")
    public List<Goods> getMyGoods(HttpSession session) {
        UserInfo userInfo = (UserInfo) session.getAttribute("userinfo");
        List<Goods> goodsList = goodsService.getForMyGoods(userInfo.getAccount().getA_id());
        return goodsList;
    }

    /**
     * 取出该学校下的商品列表
     *
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/getgoodsinschool")
    public List<Goods> getGoodsInSchool(HttpSession session, int currentPage, int pageSize) {
        School school = (School) session.getAttribute("schoolinfo");
        return goodsService.getForGoodsAtSchool(school.getS_id(), currentPage, pageSize);
    }


    /**
     * 根据二手商品id取出该二手商品的详细信息
     *
     * @param g_id
     * @param session
     * @return
     */
    @RequestMapping("/{g_id}")
    public String getGoodsById(@PathVariable("g_id") int g_id, HttpSession session, HttpServletRequest request) {
        int result = goodsService.addBrownTimes(g_id);  //增加浏览次数
        if (result > 0) {
            Goods goods = goodsService.getForGoodsById(g_id);
            if (goods == null) {
                return "redirect:/error.html";
            } else {
                List<String> picList = new ArrayList<String>();
                if (StringUtil.isNotEmpty(goods.getG_picture1())) {
                    picList.add(goods.getG_picture1());
                }
                if (StringUtil.isNotEmpty(goods.getG_picture2())) {
                    picList.add(goods.getG_picture2());
                }
                if (StringUtil.isNotEmpty(goods.getG_picture3())) {
                    picList.add(goods.getG_picture3());
                }
                if (StringUtil.isNotEmpty(goods.getG_picture4())) {
                    picList.add(goods.getG_picture4());
                }
                request.setAttribute("picList", picList);
                request.setAttribute("singleGoods", goods);
            }
        }
        return "jsp/goodsdetail";
    }

    /**
     * 获取二手商品信息传入页面便于修改
     *
     * @param g_id
     * @param request
     * @return
     */
    @RequestMapping("/update/{g_id}")
    public String getGoodsForUpdate(@PathVariable("g_id") int g_id, HttpServletRequest request, HttpSession session) {
        UserInfo userInfo = (UserInfo) session.getAttribute("userinfo");
        Goods goods = goodsService.getForUpdateGoods(g_id);
        if (goods == null) {
            return "redirect:/error.html";
        } else if (goods.getAccount().getA_id() != userInfo.getAccount().getA_id()) {   // 判断该商品的发布者是否与登陆者是否同一个人，防止sql注入攻击
            return "redirect:/error.html";
        } else {
            request.setAttribute("goodsinfo", goods);
            return "jsp/release";
        }
    }

    /**
     * 用户自行下架商品
     *
     * @param g_id
     * @return
     */
    @ResponseBody
    @RequestMapping("/offgoods")
    public int offGoods(int g_id) {
        int affectRows = goodsService.updateForOffGoods(g_id);
        return affectRows;
    }

    /**
     * 用户自行上架商品
     *
     * @param g_id
     * @return
     */
    @ResponseBody
    @RequestMapping("/ongoods")
    public int onGoods(int g_id) {
        int affectRows = goodsService.updateForOnGoods(g_id);
        return affectRows;
    }

    /**
     * 获取该学校下与该种类下的所有商品 (限学校)
     *
     * @param session
     * @param t_id
     * @return
     */
    @ResponseBody
    @RequestMapping("/typegoods")
    public List<Goods> getTypeOfGoods(int t_id, HttpSession session) {
        School school = (School) session.getAttribute("schoolinfo");
        List<Goods> goodsList = goodsService.getForGoodsInThisType(t_id, school.getS_id());
        return goodsList;
    }


    /**
     * 取出该类别下所有商品 不限学校
     *
     * @param t_id
     * @return
     */
    @ResponseBody
    @RequestMapping("/alltypegoods")
    public List<Goods> getAllTypeOfGoods(int t_id) {
        return goodsService.getForAllGoodsInThisType(t_id);
    }

    /**
     * 得到其他用户正在出售的商品
     *
     * @param a_id
     * @return
     */
    @ResponseBody
    @RequestMapping("/getotherusergoods")
    public List<Goods> getOtherUserGoods(int a_id) {
        return goodsService.getForOtherUserGoods(a_id);
    }


    /**
     * 统计该类型下二手商品个数
     *
     * @param t_id
     * @return
     */
    @ResponseBody
    @RequestMapping("/countgoods")
    public int countGoods(int t_id) {
        int goodsCount = goodsService.countForGoods(t_id);
        return goodsCount;
    }


    /**
     * 推荐商品
     *
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/recomment")
    public List<Goods> getRecomment(HttpSession session) {
        School school = (School) session.getAttribute("schoolinfo");
        List<Goods> recomments = goodsService.getRecommentGoods(school.getS_id());
        return recomments;
    }

}
