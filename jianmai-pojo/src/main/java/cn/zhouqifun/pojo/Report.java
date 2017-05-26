package cn.zhouqifun.pojo;

import java.io.Serializable;

/**
 * 摘要：举报实体类
 * @author zhouqi
 */
public class Report implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer r_id;
	private Goods goods;	 // 被举报的商品
	public Integer getR_id() {
		return r_id;
	}
	public void setR_id(Integer r_id) {
		this.r_id = r_id;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	@Override
	public String toString() {
		return "Report [r_id=" + r_id + ", goods=" + goods + "]";
	}
	public Report(Integer r_id, Account account, Goods goods) {
		super();
		this.r_id = r_id;
		this.goods = goods;
	}
	
	public Report() {
		// TODO Auto-generated constructor stub
	}
}
