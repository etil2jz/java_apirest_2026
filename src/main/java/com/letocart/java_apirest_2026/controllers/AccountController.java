package com.letocart.java_apirest_2026.controllers;

import com.letocart.java_apirest_2026.models.dao.AccountEntity;
import com.letocart.java_apirest_2026.models.dto.CreateAccount;
import com.letocart.java_apirest_2026.models.mappers.AccountMapper;
import com.letocart.java_apirest_2026.services.account.AccountService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AccountController {

    private final AccountMapper mapper;
    private final AccountService service;

    @PostMapping("/account")
    public AccountEntity save(@RequestBody CreateAccount account) {
        // ATTENTION pour le save il faut que dans le body supprimer
        // le account_id en effet pour JPA il faut que account_id soit null
        // Vu qu'on utilise un Long


        return service.save(mapper.buildDaoFromDto(account));
    }

    @GetMapping("/account/{accountId}")
    public ResponseEntity<AccountEntity> findById(@PathVariable Long accountId) {
        return service.findById(accountId);
    }

    @GetMapping("/account")
    public List<AccountEntity> findAll() {
        return service.findAll();
    }
}
