package com.company.account_service.controller;

import com.company.account_service.model.Account;
import com.company.account_service.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/addAccount")
    public ResponseEntity<Account> addAccount() {
        return new ResponseEntity<>(accountService.addAccount(), HttpStatus.CREATED);
    }
}
