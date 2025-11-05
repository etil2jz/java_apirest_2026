package com.letocart.java_apirest_2026.controllers;

import com.letocart.java_apirest_2026.models.dao.AccountEntity;
import com.letocart.java_apirest_2026.models.dto.CreateAccount;
import com.letocart.java_apirest_2026.models.mappers.AccountMapper;
import com.letocart.java_apirest_2026.services.account.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AccountController {

	private final AccountMapper mapper;
	private final AccountService service;

	@PostMapping("/account")
	public AccountEntity save(@RequestBody @Valid CreateAccount account) {
		return service.save(mapper.buildDaoFromDto(account));
	}

	@GetMapping("/account/{accountId}")
	public ResponseEntity<AccountEntity> findById(@PathVariable Long accountId) {
		return ResponseEntity.ok(service.findById(accountId));
	}

	@GetMapping("/account")
	public List<AccountEntity> findAll() {
		return service.findAll();
	}

}
