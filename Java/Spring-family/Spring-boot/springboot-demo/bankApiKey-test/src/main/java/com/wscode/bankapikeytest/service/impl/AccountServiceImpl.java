package com.wscode.bankapikeytest.service.impl;

import com.wscode.bankapikeytest.entity.Account;
import com.wscode.bankapikeytest.repository.AccountRepository;
import com.wscode.bankapikeytest.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
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

}
