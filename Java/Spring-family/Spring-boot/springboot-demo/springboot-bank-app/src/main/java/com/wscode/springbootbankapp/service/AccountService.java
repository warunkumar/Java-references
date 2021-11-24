package com.wscode.springbootbankapp.service;

import com.wscode.springbootbankapp.controller.request.TransferBalanceRequest;
import com.wscode.springbootbankapp.dto.model.AccountStatement;
import com.wscode.springbootbankapp.entity.Account;
import com.wscode.springbootbankapp.entity.Transaction;

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
    Transaction sendMoney(
            TransferBalanceRequest transferBalanceRequest
    );
    AccountStatement getStatement(String accountNumber);
}
