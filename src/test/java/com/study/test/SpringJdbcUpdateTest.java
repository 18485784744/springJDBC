package com.study.test;

import com.study.dao.IAccountDao;
import com.study.po.Account;
import org.junit.Test;

import javax.annotation.Resource;

public class SpringJdbcUpdateTest {
    @Resource
    private IAccountDao iAccountDao;

    /**
     * 修改账户记录，返回受影响的行数
     */
    @Test
    public void testUpdateAccount(){
        Account account=new Account("账户A","农业银行",2000.0,"奖金",1);
        account.setAccountId(4);
        int row=iAccountDao.updateAccount(account);
        System.out.println(row);
    }
}
