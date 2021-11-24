package com.wscode.springbootbankapp.service.impl;

import com.wscode.springbootbankapp.controller.request.TransferBalanceRequest;
import com.wscode.springbootbankapp.dto.model.AccountStatement;
import com.wscode.springbootbankapp.entity.Account;
import com.wscode.springbootbankapp.entity.Transaction;
import com.wscode.springbootbankapp.repository.AccountRepository;
import com.wscode.springbootbankapp.repository.TransactionRepository;
import com.wscode.springbootbankapp.service.AccountService;
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

    @Autowired
    TransactionRepository transactionRepository;

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


    @Override
    public Transaction sendMoney(
            TransferBalanceRequest transferBalanceRequest
    ) {
        String fromAccountNumber = transferBalanceRequest.getFromAccountNumber();
        String toAccountNumber = transferBalanceRequest.getToAccountNumber();
        BigDecimal amount = transferBalanceRequest.getAmount();
        Account fromAccount = accountRepository.findByAccountNumberEquals(
                fromAccountNumber
        );
        Account toAccount = accountRepository.findByAccountNumberEquals(toAccountNumber);
        if (fromAccount.getCurrentBalance().compareTo(BigDecimal.ONE) == 1
                && fromAccount.getCurrentBalance().compareTo(amount) == 1
        ) {
            fromAccount.setCurrentBalance(fromAccount.getCurrentBalance().subtract(amount));
            accountRepository.save(fromAccount);
            toAccount.setCurrentBalance(toAccount.getCurrentBalance().add(amount));
            accountRepository.save(toAccount);
            Transaction transaction = transactionRepository.save(new Transaction(0L, fromAccountNumber, amount, new Timestamp(System.currentTimeMillis())));
            return transaction;
        }
        return null;
    }

    @Override
    public AccountStatement getStatement(String accountNumber) {
        Account account = accountRepository.findByAccountNumberEquals(accountNumber);
        return new AccountStatement(account.getCurrentBalance(), transactionRepository.findByAccountNumberEquals(accountNumber));
    }
}
