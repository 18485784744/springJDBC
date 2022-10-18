package com.study.test;

import com.study.service.AccountService;
import org.junit.Test;

import javax.annotation.Resource;

public class SpringJdbcTest05 extends BaseTest{
    @Resource
    private AccountService accountService;

    @Test
    public void test(){
        int code=accountService.toupdateAccountByTranfer(5,6,100.0);

        if (code==1){
            System.out.println("转账成功！！！");
        }
    }
}
