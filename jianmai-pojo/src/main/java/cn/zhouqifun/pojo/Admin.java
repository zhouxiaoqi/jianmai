package cn.zhouqifun.pojo;

import java.io.Serializable;

/**
 * 摘要：管理员实体类
 * @author zhouqi
 *
 */
public class Admin implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer ad_id;
	private String ad_username;// 管理员账户
	private String ad_password;// 管理员密码
	private String ad_nickname;// 管理员名称
	public Integer getAd_id() {
		return ad_id;
	}
	public void setAd_id(Integer ad_id) {
		this.ad_id = ad_id;
	}
	public String getAd_username() {
		return ad_username;
	}
	public void setAd_username(String ad_username) {
		this.ad_username = ad_username;
	}
	public String getAd_password() {
		return ad_password;
	}
	public void setAd_password(String ad_password) {
		this.ad_password = ad_password;
	}
	public String getAd_nickname() {
		return ad_nickname;
	}
	public void setAd_nickname(String ad_nickname) {
		this.ad_nickname = ad_nickname;
	}
	@Override
	public String toString() {
		return "Admin [ad_id=" + ad_id + ", ad_username=" + ad_username + ", ad_password=" + ad_password
				+ ", ad_nickname=" + ad_nickname + "]";
	}
	public Admin(Integer ad_id, String ad_username, String ad_password, String ad_nickname) {
		super();
		this.ad_id = ad_id;
		this.ad_username = ad_username;
		this.ad_password = ad_password;
		this.ad_nickname = ad_nickname;
	}
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}

}
