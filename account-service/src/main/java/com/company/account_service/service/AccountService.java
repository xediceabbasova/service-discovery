package com.company.account_service.service;

import com.company.account_service.model.Account;
import com.company.account_service.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final RestTemplate restTemplate;

    public AccountService(AccountRepository accountRepository, RestTemplate restTemplate) {
        this.accountRepository = accountRepository;
        this.restTemplate = restTemplate;
    }

    private static final String URL = "http://NAME-SERVICE/name/getName";

    public Account addAccount() {
        String name = restTemplate.getForObject(URL, String.class);
        Account account = Account.builder()
                .name(name)
                .build();

        return accountRepository.save(account);
    }


}
