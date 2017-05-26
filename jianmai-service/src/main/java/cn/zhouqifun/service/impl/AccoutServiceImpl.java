package cn.zhouqifun.service.impl;

import cn.zhouqifun.mapper.AccountDao;
import cn.zhouqifun.pojo.Account;
import cn.zhouqifun.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhouqi on 2017/3/19.
 */
@Service("accountService")
public class AccoutServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    /**
     * @param email 用户输入邮箱
     * @return
     */
    @Override
    public String getForValidateEmail(String email) {
        return accountDao.getForValidateEmail(email);
    }

    /**
     * @param account 注册
     * @return
     */
    @Override
    public int insertForRegist(Account account) {
        return accountDao.insertForRegist(account);
    }
    
    /**
     * 登陆
     */
	@Override
	public Account getForLogin(String email, String password) {
		return accountDao.getForLogin(email, password);
	}

    @Override
    public int updateForpassword(Account account) {
        return accountDao.updateForpassword(account);
    }
}
