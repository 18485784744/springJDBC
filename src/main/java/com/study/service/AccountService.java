package com.study.service;

import com.study.dao.AccountDaoImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class AccountService {
    @Resource
    private AccountDaoImpl accountDaoImpl;

    @Transactional(propagation = Propagation.REQUIRED)
    public int toupdateAccountByTranfer(Integer outId,Integer inId,Double money){
      int code=0;//成功或失败   1=成功，0=失败
        /**
         * 账户A向账户B转账100元
         *  账户A：金额-100
         *  账户B：金额+100
         */
        // 账户A 支出，修改账户金额，返回受影响的行数
        int outRow=accountDaoImpl.outAccount(outId,money);

        int a=1/0;
        // 账户B 收入，修改账户金额，返回受影响的行数
        int inrow=accountDaoImpl.inAccount(inId,money);

        if (outRow==1&&inrow==1){
            code=1;
        }
        return code;
    }
}
