package com.wscode.banktestcase.service;

import com.wscode.banktestcase.entity.Account;
import com.wscode.banktestcase.repository.AccountRepository;
import com.wscode.banktestcase.service.impl.AccountServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author warun
 * @createdOn 11/27/2021
 */


public class AccountServiceImplTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void sumOfThreeNumberTest(){
        AccountServiceImpl accountService=new AccountServiceImpl();
        int actualResult=accountService.sumOfNumber(new int[] {1,2,3});
        int expectedResult=6;
        assertEquals(expectedResult,actualResult);


    }
    @Test
    public void sumOfNullNumberTest(){
        AccountServiceImpl accountService=new AccountServiceImpl();
        int actualResult=accountService.sumOfNumber(new int[] {});
        int expectedResult=0;
        assertEquals(expectedResult,actualResult);


    }

    @Test
    public void findByAccountNumberTest(){
        AccountServiceImpl accountService=new AccountServiceImpl();
        accountService.setAccountRepository(accountRepository);
        int actualResult =Integer.getInteger(accountService.findByAccountNumber("2").getAccountNumber());
        int expectedResult=1;
        assertEquals(expectedResult,actualResult);


    }
}
