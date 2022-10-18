package com.study.test;

import com.study.dao.AccountDaoImpl;
import com.study.po.Account;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class SpringJdbcQueryTest extends BaseTest {
    @Resource
    private AccountDaoImpl accountDaoImpl;

    /**
     * 查询指定用户的账户总记录数，返回总数量
     */
    @Test
    public void testQueryAccountCount(){
        int total=accountDaoImpl.queryAccountCount(1);
        System.out.println("查询指定用户的账户总记录数："+total);
    }

    /**
     * 查询指定账户记录的详情，返回账户对象
     */
    @Test
    public void testQueryAccountById(){
        Account account=accountDaoImpl.queryAccountById(1);
        System.out.println("账户详情："+account.toString());
    }
    @Test
    public void testQueryAccountList(){
//        List<Account> accountList=accountDaoImpl.queryAccountByParams(2,null,null,null);
//        System.out.println(accountList.toString());

        List<Account> accountList1=accountDaoImpl.queryAccountByParams(1,"账户A",null,null);
        System.out.println(accountList1.toString());
    }
}
