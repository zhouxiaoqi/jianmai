package cn.zhouqifun.pojo;

/**
 * Created by zhouqi on 2017/5/6.
 */
public class SearchGoods {

    private Integer g_id;
    private String g_name;
    private String g_picture1;
    private String g_place;
    private Long g_price;
    private String g_bargain;

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

    public String getG_picture1() {
        return g_picture1;
    }

    public void setG_picture1(String g_picture1) {
        this.g_picture1 = g_picture1;
    }

    public String getG_place() {
        return g_place;
    }

    public void setG_place(String g_place) {
        this.g_place = g_place;
    }

    public Long getG_price() {
        return g_price;
    }

    public void setG_price(Long g_price) {
        this.g_price = g_price;
    }

    public String getG_bargain() {
        return g_bargain;
    }

    public void setG_bargain(String g_bargain) {
        this.g_bargain = g_bargain;
    }

    @Override
    public String toString() {
        return "SearchGoods{" +
                "g_id='" + g_id + '\'' +
                ", g_name='" + g_name + '\'' +
                ", g_picture1='" + g_picture1 + '\'' +
                ", g_place='" + g_place + '\'' +
                ", g_price=" + g_price +
                ", g_bargain='" + g_bargain + '\'' +
                '}';
    }

    public SearchGoods(Integer g_id, String g_name, String g_picture1, String g_place, Long g_price, String g_bargain) {
        this.g_id = g_id;
        this.g_name = g_name;
        this.g_picture1 = g_picture1;
        this.g_place = g_place;
        this.g_price = g_price;
        this.g_bargain = g_bargain;
    }

    public SearchGoods(){}
}
