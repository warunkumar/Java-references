package com.wscode.banktestcase.service.impl;

import com.wscode.banktestcase.entity.Account;
import com.wscode.banktestcase.repository.AccountRepository;
import com.wscode.banktestcase.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Warun
 * @createdOn 18-10-2021
 **/
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    /*public AccountRepository getAccountRepository() {
        return accountRepository;
    }*/

    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account save(Account account) {
        accountRepository.save(account);
        return accountRepository.findByAccountNumberEquals(account.getAccountNumber());
    }

    @Override
    public Account updateAccountById(Long accountId) {
        Optional<Account> account=accountRepository.findById(accountId);
        return accountRepository.save(account.get());
    }

    @Override
    public void deleteAccountById(Long accountId) {
        Optional<Account> account=accountRepository.findById(accountId);
        accountRepository.delete(account.get());
    }


    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public Account findByAccountNumber(String accountNumber) {
        Account account = accountRepository.findByAccountNumberEquals(accountNumber);
        return account;
    }

    public int sumOfNumber(int[] number){
        int sum=0;
        for(int n:number){
            sum+=n;
        }
        return sum;
    }

}
