package cn.zhouqifun.pojo;

import java.io.Serializable;

/**
 * 摘要：黑名单实体类
 * @author zhouqi
 *
 */
public class BlackList implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer b_id;
	private Account account; //被封号的账户
	private String b_reason; //被封号的理由
	private String b_time; //封号时间

	public Integer getB_id() {
		return b_id;
	}

	public void setB_id(Integer b_id) {
		this.b_id = b_id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getB_reason() {
		return b_reason;
	}

	public void setB_reason(String b_reason) {
		this.b_reason = b_reason;
	}



	public String getB_time() {
		return b_time;
	}

	public void setB_time(String b_time) {
		this.b_time = b_time;
	}


	@Override
	public String toString() {
		return "BlackList [b_id=" + b_id + ", account=" + account + ", b_reason=" + b_reason + ", b_time=" + b_time
				+ "]";
	}

	public BlackList(Integer b_id, Account account, String b_reason, String b_time) {
		super();
		this.b_id = b_id;
		this.account = account;
		this.b_reason = b_reason;
		this.b_time = b_time;
	}

	public BlackList() {
		// TODO Auto-generated constructor stub
	}
}
