package cn.zhouqifun.pojo;

import java.io.Serializable;
import java.sql.Date;

/**
 * 摘要：求购商品实体类
 * @author zhouqi
 *
 */
public class Want implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer w_id;
	private String w_name; //求购商品名
	private String w_desc; //商品描述
	private String w_price;//期望价格
	private String w_place; // 交易地点
	private String w_phonenum;//手机号码
	private String w_qq;//qq
	/*
	 * showornot: 0:待审核状态 1:上架状态 -1:驳回状态 2：下架状态
	 * */
	private int w_showornot;
	private School school;//隶属于学校
	private Account account;//发布者
	private Date w_createdtime; //发布时间
	private String w_rejectreason; //驳回理由
	public Integer getW_id() {
		return w_id;
	}
	public void setW_id(Integer w_id) {
		this.w_id = w_id;
	}
	public String getW_name() {
		return w_name;
	}
	public void setW_name(String w_name) {
		this.w_name = w_name;
	}
	public String getW_desc() {
		return w_desc;
	}
	public void setW_desc(String w_desc) {
		this.w_desc = w_desc;
	}
	public String getW_price() {
		return w_price;
	}
	public void setW_price(String w_price) {
		this.w_price = w_price;
	}

	public String getW_place() {
		return w_place;
	}

	public void setW_place(String w_place) {
		this.w_place = w_place;
	}

	public String getW_phonenum() {
		return w_phonenum;
	}
	public void setW_phonenum(String w_phonenum) {
		this.w_phonenum = w_phonenum;
	}
	public String getW_qq() {
		return w_qq;
	}
	public void setW_qq(String w_qq) {
		this.w_qq = w_qq;
	}
	public int getW_showornot() {
		return w_showornot;
	}
	public void setW_showornot(int w_showornot) {
		this.w_showornot = w_showornot;
	}
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}

	public Date getW_createdtime() {
		return w_createdtime;
	}

	public void setW_createdtime(Date w_createdtime) {
		this.w_createdtime = w_createdtime;
	}

	public String getW_rejectreason() {
		return w_rejectreason;
	}

	public void setW_rejectreason(String w_rejectreason) {
		this.w_rejectreason = w_rejectreason;
	}

	@Override
	public String toString() {
		return "Want{" +
				"w_id=" + w_id +
				", w_name='" + w_name + '\'' +
				", w_desc='" + w_desc + '\'' +
				", w_price='" + w_price + '\'' +
				", w_place='" + w_place + '\'' +
				", w_phonenum='" + w_phonenum + '\'' +
				", w_qq='" + w_qq + '\'' +
				", w_showornot=" + w_showornot +
				", school=" + school +
				", account=" + account +
				", w_createdtime=" + w_createdtime +
				", w_rejectreason='" + w_rejectreason + '\'' +
				'}';
	}

	public Want(Integer w_id, String w_name, String w_desc, String w_price, String w_place, String w_phonenum, String w_qq, int w_showornot, School school, Account account, Date w_createdtime, String w_rejectreason) {
		this.w_id = w_id;
		this.w_name = w_name;
		this.w_desc = w_desc;
		this.w_price = w_price;
		this.w_place = w_place;
		this.w_phonenum = w_phonenum;
		this.w_qq = w_qq;
		this.w_showornot = w_showornot;
		this.school = school;
		this.account = account;
		this.w_createdtime = w_createdtime;
		this.w_rejectreason = w_rejectreason;
	}

	public Want() {
		// TODO Auto-generated constructor stub
	}

}
