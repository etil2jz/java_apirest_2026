package xyz.blanchot.java_apirest_2026_fork.controllers;

import xyz.blanchot.java_apirest_2026_fork.models.dao.AccountEntity;
import xyz.blanchot.java_apirest_2026_fork.models.dto.CreateAccount;
import xyz.blanchot.java_apirest_2026_fork.models.mappers.AccountMapper;
import xyz.blanchot.java_apirest_2026_fork.services.account.AccountService;
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
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

	private final AccountMapper mapper;
	private final AccountService service;

	@PostMapping
	public AccountEntity save(@RequestBody @Valid CreateAccount account) {
		return service.save(mapper.buildDaoFromDto(account));
	}

	@GetMapping("/{accountId}")
	public ResponseEntity<AccountEntity> findById(@PathVariable Long accountId) {
		return ResponseEntity.ok(service.findById(accountId));
	}

	@GetMapping
	public List<AccountEntity> findAll() {
		return service.findAll();
	}

}
