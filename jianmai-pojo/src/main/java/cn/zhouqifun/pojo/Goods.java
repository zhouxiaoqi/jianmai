package cn.zhouqifun.pojo;

import java.io.Serializable;
import java.sql.Date;


/**
 * 摘要：商品实体类
 *
 * @author zhouqi
 */
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer g_id;
    private String g_name;  //商品名
    private String g_desc;    //商品描述
    private String g_place;    //交易地点
    private double g_price;    //商品价格
    private String g_bargain;   //是否可接收还价
    private String g_phonenum;//联系电话
    private String g_qq;//联系qq
    private String g_picture1;//商品图1
    private String g_picture2;//商品图2
    private String g_picture3;//商品图3
    private String g_picture4;//商品图4
    private int g_showornot; //5种状态 -1：驳回  1：上架中  0：审核中  2：已下架  3:已售出
    private String g_rejectreason; // 驳回理由;
    private Date g_createdTime; //创建时间
    private Account account; // 发布商品的用户
    private School school;    //此商品隶属于的学校
    private Type type;        // 此商品属于的类型
    private int brownTimes;  // 浏览次数

    public Integer getG_id() {
        return g_id;
    }

    public void setG_id(Integer g_id) {
        this.g_id = g_id;
    }

    public String getG_name() {
        return g_name;
    }

    public void setG_name(String g_name) {
        this.g_name = g_name;
    }

    public String getG_desc() {
        return g_desc;
    }

    public void setG_desc(String g_desc) {
        this.g_desc = g_desc;
    }

    public String getG_place() {
        return g_place;
    }

    public void setG_place(String g_place) {
        this.g_place = g_place;
    }

    public double getG_price() {
        return g_price;
    }

    public void setG_price(double g_price) {
        this.g_price = g_price;
    }

    public String getG_bargain() {
        return g_bargain;
    }

    public void setG_bargain(String g_bargain) {
        this.g_bargain = g_bargain;
    }

    public String getG_phonenum() {
        return g_phonenum;
    }

    public void setG_phonenum(String g_phonenum) {
        this.g_phonenum = g_phonenum;
    }

    public String getG_qq() {
        return g_qq;
    }

    public void setG_qq(String g_qq) {
        this.g_qq = g_qq;
    }

    public String getG_picture1() {
        return g_picture1;
    }

    public void setG_picture1(String g_picture1) {
        this.g_picture1 = g_picture1;
    }

    public String getG_picture2() {
        return g_picture2;
    }

    public void setG_picture2(String g_picture2) {
        this.g_picture2 = g_picture2;
    }

    public String getG_picture3() {
        return g_picture3;
    }

    public void setG_picture3(String g_picture3) {
        this.g_picture3 = g_picture3;
    }

    public String getG_picture4() {
        return g_picture4;
    }

    public void setG_picture4(String g_picture4) {
        this.g_picture4 = g_picture4;
    }

    public int getG_showornot() {
        return g_showornot;
    }

    public void setG_showornot(int g_showornot) {
        this.g_showornot = g_showornot;
    }

    public String getG_rejectreason() {
        return g_rejectreason;
    }

    public void setG_rejectreason(String g_rejectreason) {
        this.g_rejectreason = g_rejectreason;
    }

    public Date getG_createdTime() {
        return g_createdTime;
    }

    public void setG_createdTime(Date g_createdTime) {
        this.g_createdTime = g_createdTime;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getBrownTimes() {
        return brownTimes;
    }

    public void setBrownTimes(int brownTimes) {
        this.brownTimes = brownTimes;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "g_id=" + g_id +
                ", g_name='" + g_name + '\'' +
                ", g_desc='" + g_desc + '\'' +
                ", g_place='" + g_place + '\'' +
                ", g_price=" + g_price +
                ", g_bargain='" + g_bargain + '\'' +
                ", g_phonenum='" + g_phonenum + '\'' +
                ", g_qq='" + g_qq + '\'' +
                ", g_picture1='" + g_picture1 + '\'' +
                ", g_picture2='" + g_picture2 + '\'' +
                ", g_picture3='" + g_picture3 + '\'' +
                ", g_picture4='" + g_picture4 + '\'' +
                ", g_showornot=" + g_showornot +
                ", g_rejectreason='" + g_rejectreason + '\'' +
                ", account=" + account +
                ", school=" + school +
                ", type=" + type +
                '}';
    }

    public Goods(Integer g_id, String g_name, String g_desc, String g_place, double g_price, String g_bargain, String g_phonenum, String g_qq, String g_picture1, String g_picture2, String g_picture3, String g_picture4, int g_showornot, String g_rejectreason, Account account, School school, Type type) {
        this.g_id = g_id;
        this.g_name = g_name;
        this.g_desc = g_desc;
        this.g_place = g_place;
        this.g_price = g_price;
        this.g_bargain = g_bargain;
        this.g_phonenum = g_phonenum;
        this.g_qq = g_qq;
        this.g_picture1 = g_picture1;
        this.g_picture2 = g_picture2;
        this.g_picture3 = g_picture3;
        this.g_picture4 = g_picture4;
        this.g_showornot = g_showornot;
        this.g_rejectreason = g_rejectreason;
        this.account = account;
        this.school = school;
        this.type = type;
    }

    public Goods() {
        // TODO Auto-generated constructor stub
    }

}
