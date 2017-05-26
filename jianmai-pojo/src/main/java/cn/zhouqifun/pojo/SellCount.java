package cn.zhouqifun.pojo;

/**
 * 统计该学校成功交易次数
 * Created by zhouqi on 2017/4/13.
 */
public class SellCount {

    private int sc_id;
    private int count; //统计次数
    private School school;


    public int getSc_id() {
        return sc_id;
    }

    public void setSc_id(int sc_id) {
        this.sc_id = sc_id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "SellCount{" +
                "sc_id=" + sc_id +
                ", count=" + count +
                ", school=" + school +
                '}';
    }

    public SellCount(int sc_id, int count, School school) {
        this.sc_id = sc_id;
        this.count = count;
        this.school = school;
    }

    public SellCount() {
    }
}
