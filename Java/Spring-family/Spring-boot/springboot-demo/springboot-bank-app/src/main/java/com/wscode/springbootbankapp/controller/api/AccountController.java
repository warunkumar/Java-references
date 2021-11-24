package com.wscode.springbootbankapp.controller.api;

import com.wscode.springbootbankapp.entity.Account;
import com.wscode.springbootbankapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Warun
 * @createdOn 18-10-2021
 **/
@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping(value = "/all")
    public List<Account> all() {
        return accountService.findAll();
    }

    @PostMapping(value = "/create")
    public Account createNewAccount( @RequestBody Account account){
        return accountService.save(account);
    }

    @PutMapping(value = "/updateAccountById/{accountId}")
    public Account updateAccountById(@PathVariable Long accountId){
        return accountService.updateAccountById(accountId);
    }

    @DeleteMapping(value = "/deleteAccountById/{accountId}")
    public void deleteAccountById(@PathVariable Long accountId){
        accountService.deleteAccountById(accountId);
    }


}
