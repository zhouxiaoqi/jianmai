package cn.zhouqifun.pojo;

import java.io.Serializable;

/**
 * 摘要：收藏实体类
 * @author zhouqi
 *
 */
public class Collect implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer c_id;
	private Account account;//收藏商品的用户
	private Goods goods;	//收藏的商品
	private String showornot;//是否取消收藏
	public Integer getC_id() {
		return c_id;
	}
	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public String getShowornot() {
		return showornot;
	}
	public void setShowornot(String showornot) {
		this.showornot = showornot;
	}
	@Override
	public String toString() {
		return "Collection [c_id=" + c_id + ", account=" + account + ", goods=" + goods + ", showornot=" + showornot
				+ "]";
	}
	public Collect(Integer c_id, Account account, Goods goods, String showornot) {
		super();
		this.c_id = c_id;
		this.account = account;
		this.goods = goods;
		this.showornot = showornot;
	}
	
	public Collect() {
		// TODO Auto-generated constructor stub
	}
}
