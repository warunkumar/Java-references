package com.wscode.banktestcase.service;


import com.wscode.banktestcase.entity.Account;

import java.util.List;

/**
 * @author Warun
 * @createdOn 18-10-2021
 **/
public interface AccountService {
    List<Account> findAll();
    Account save(Account account);
    Account updateAccountById(Long accountId);
    void deleteAccountById(Long accountId);
    }
