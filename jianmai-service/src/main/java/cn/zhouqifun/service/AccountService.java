package cn.zhouqifun.service;


import cn.zhouqifun.pojo.Account;

/**
 * Created by zhouqi on 2017/3/19.
 */
public interface AccountService {

    /**
     * 验证该邮箱是否已经被注册
     * @param email 用户输入邮箱
     * @return 返回查询结果
     */
    String getForValidateEmail(String email);


    /**
     * 用户注册
     *
     * @param account 注册
     * @return 返回插入该条记录的id，便于后续使用
     */
    int insertForRegist(Account account);
    
    /**
     * 用户登陆
     * @param email 账户
     * @param password 密码
     * @return 返回该条记录，便于后续使用
     */
    Account getForLogin(String email, String password);


    /**
     * 修改密码
     * @param account
     * @return
     */
    int updateForpassword(Account account);
}
