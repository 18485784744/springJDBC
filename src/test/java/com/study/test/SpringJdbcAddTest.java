package com.study.test;

import com.study.dao.AccountDaoImpl;
import com.study.dao.IAccountDao;
import com.study.po.Account;
import org.junit.Test;

import javax.annotation.Resource;
import javax.swing.plaf.basic.BasicTreeUI;
import java.util.ArrayList;
import java.util.List;

/**
 * 账户模块添加操作测试类
 */
public class SpringJdbcAddTest extends BaseTest {

    //注入
    @Resource
    private AccountDaoImpl accountDaoImpl;

    /**
     * 添加账户记录，返回受影响的行数
     */
    @Test
    public void testAddAccount() {
        // 准备要添加的数据        String accountName, String accountType, Double money, String remark, Integer userId
        Account account = new Account("账户5", "贵阳银行", 3000.0, "工资", 4);
        //调用对象中的添加方法，返回受影响行数
        int row = accountDaoImpl.addAccount(account);
        System.out.println("添加账户，受影响的行数：" + row);
    }

    /**
     * 添加账户记录，返回主键
     */
    @Test
    public void testAddAccountHaskey() {
        //准备要添加的数据
        Account account = new Account("账户5", "北京银行", 5000.0, "奖金", 6);
        int key = accountDaoImpl.addAccountHaskey(account);
        System.out.println("添加账户，返回主键：" + key);
    }
    /**
     * 批量添加账户记录，返回受影响的行数
     */
    @Test
    public void testBatchAddAccount(){
        Account account1 = new Account("账户5","农业银行",700.0,"奖金",3);
        Account account2 = new Account("账户6","工商银行",890.0,"早餐",3);
        Account account3 = new Account("账户7","中国银行",560.0,"绩效奖",3);

        List<Account> accounts=new ArrayList<>();
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);

        int rows=accountDaoImpl.addAccountBath(accounts);
        System.out.println("批量添加账户记录，返回受影响的行数："+rows);
    }
}
