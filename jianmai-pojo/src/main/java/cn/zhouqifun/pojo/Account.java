package cn.zhouqifun.pojo;

import java.io.Serializable;

/**
 * 摘要：账户表
 * 
 * @author zhouqi
 *
 */
public class Account implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int a_id;
	private String nickname;// 昵称
	private String email; // 邮箱(用来登陆
	private String password;

	public int getA_id() {
		return a_id;
	}

	public void setA_id(int a_id) {
		this.a_id = a_id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Account [a_id=" + a_id + ", nickname=" + nickname + ", email=" + email + ", password=" + password + "]";
	}

	public Account(int a_id, String nickname, String email, String password) {
		super();
		this.a_id = a_id;
		this.nickname = nickname;
		this.email = email;
		this.password = password;
	}

	public Account() {
		// TODO Auto-generated constructor stub
	}

}
