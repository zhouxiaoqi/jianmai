package cn.zhouqifun.pojo;

/**
 * 广告内容
 * Created by zhouqi on 2017/4/23.
 */
public class Advers {

    private int ad_id;
    private String ad_image;
    private String ad_desc;
    private String ad_position;

    public int getAd_id() {
        return ad_id;
    }

    public void setAd_id(int ad_id) {
        this.ad_id = ad_id;
    }

    public String getAd_image() {
        return ad_image;
    }

    public void setAd_image(String ad_image) {
        this.ad_image = ad_image;
    }

    public String getAd_desc() {
        return ad_desc;
    }

    public void setAd_desc(String ad_desc) {
        this.ad_desc = ad_desc;
    }

    public String getAd_position() {
        return ad_position;
    }

    public void setAd_position(String ad_position) {
        this.ad_position = ad_position;
    }

    @Override
    public String toString() {
        return "Advers{" +
                "ad_id=" + ad_id +
                ", ad_image='" + ad_image + '\'' +
                ", ad_desc='" + ad_desc + '\'' +
                ", ad_position='" + ad_position + '\'' +
                '}';
    }

    public Advers(int ad_id, String ad_image, String ad_desc, String ad_position) {
        this.ad_id = ad_id;
        this.ad_image = ad_image;
        this.ad_desc = ad_desc;
        this.ad_position = ad_position;
    }

    public Advers(){}
}
