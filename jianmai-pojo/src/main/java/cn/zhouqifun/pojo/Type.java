package cn.zhouqifun.pojo;

import java.io.Serializable;

/**
 * 摘要：商品类型实体
 *
 * @author zhouqi
 */
public class Type implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Integer t_id;
    private String t_typename;        //类型名字
    private String t_typeimgforpc; //pc端类别图
    private String t_typeimgforphone; //手机端类别图
    private String t_typedesc; //类别描述

    public Integer getT_id() {
        return t_id;
    }

    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }

    public String getT_typename() {
        return t_typename;
    }

    public void setT_typename(String t_typename) {
        this.t_typename = t_typename;
    }

    public String getT_typeimgforpc() {
        return t_typeimgforpc;
    }

    public void setT_typeimgforpc(String t_typeimgforpc) {
        this.t_typeimgforpc = t_typeimgforpc;
    }

    public String getT_typeimgforphone() {
        return t_typeimgforphone;
    }

    public void setT_typeimgforphone(String t_typeimgforphone) {
        this.t_typeimgforphone = t_typeimgforphone;
    }

    public String getT_typedesc() {
        return t_typedesc;
    }

    public void setT_typedesc(String t_typedesc) {
        this.t_typedesc = t_typedesc;
    }

    @Override
    public String toString() {
        return "Type{" +
                "t_id=" + t_id +
                ", t_name='" + t_typename + '\'' +
                ", t_typeimgforpc='" + t_typeimgforpc + '\'' +
                ", t_typeimgforphone='" + t_typeimgforphone + '\'' +
                ", t_typedesc='" + t_typedesc + '\'' +
                '}';
    }

    public Type(Integer t_id, String t_name, String t_typeimgforpc, String t_typeimgforphone, String t_typedesc) {
        this.t_id = t_id;
        this.t_typename = t_name;
        this.t_typeimgforpc = t_typeimgforpc;
        this.t_typeimgforphone = t_typeimgforphone;
        this.t_typedesc = t_typedesc;
    }

    public Type() {
    }
}
