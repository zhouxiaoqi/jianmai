package cn.zhouqifun.pojo;

import java.io.Serializable;

/**
 * 摘要：用户个人信息实体类
 * @author zhouqi
 *
 */
public class UserInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer u_id;
	private String u_phonenum;	//用户手机
	private String u_qq;		//用户qq
	private String u_headerpic; //用户头像
	private Account account;	//该信息属于的账户
	public Integer getU_id() {
		return u_id;
	}
	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}
	public String getU_phonenum() {
		return u_phonenum;
	}
	public void setU_phonenum(String u_phonenum) {
		this.u_phonenum = u_phonenum;
	}
	public String getU_qq() {
		return u_qq;
	}
	public void setU_qq(String u_qq) {
		this.u_qq = u_qq;
	}
	public String getU_headerpic() {
		return u_headerpic;
	}
	public void setU_headerpic(String u_headerpic) {
		this.u_headerpic = u_headerpic;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	@Override
	public String toString() {
		return "UserInfo [u_id=" + u_id + ", u_phonenum=" + u_phonenum + ", u_qq=" + u_qq + ", u_headerpic="
				+ u_headerpic + ", account=" + account + "]";
	}
	public UserInfo(Integer u_id, String u_phonenum, String u_qq, String u_headerpic, Account account) {
		super();
		this.u_id = u_id;
		this.u_phonenum = u_phonenum;
		this.u_qq = u_qq;
		this.u_headerpic = u_headerpic;
		this.account = account;
	}
	
	public UserInfo() {
		// TODO Auto-generated constructor stub
	}
	
}
