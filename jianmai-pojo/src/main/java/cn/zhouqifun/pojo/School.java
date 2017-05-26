package cn.zhouqifun.pojo;

import java.io.Serializable;

/**
 * 摘要：学校实体类
 *
 * @author zhouqi
 */
public class School implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Integer s_id;
    private String s_name;  //学校名
    private String s_badge; //校徽
    private String s_address;// 学校地址
    private String s_campus;//校区

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getS_badge() {
        return s_badge;
    }

    public void setS_badge(String s_badge) {
        this.s_badge = s_badge;
    }

    public String getS_address() {
        return s_address;
    }

    public void setS_address(String s_address) {
        this.s_address = s_address;
    }

    public String getS_campus() {
        return s_campus;
    }

    public void setS_campus(String s_campus) {
        this.s_campus = s_campus;
    }

    @Override
    public String toString() {
        return "School{" +
                "s_id=" + s_id +
                ", s_name='" + s_name + '\'' +
                ", s_badge='" + s_badge + '\'' +
                ", s_address='" + s_address + '\'' +
                ", s_campus='" + s_campus + '\'' +
                '}';
    }

    public School(Integer s_id, String s_name, String s_badge, String s_address, String s_campus) {
        this.s_id = s_id;
        this.s_name = s_name;
        this.s_badge = s_badge;
        this.s_address = s_address;
        this.s_campus = s_campus;
    }

    public School(){}
}
