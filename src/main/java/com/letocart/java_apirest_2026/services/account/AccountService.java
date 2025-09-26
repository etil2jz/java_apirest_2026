package com.letocart.java_apirest_2026.services.account;

import com.letocart.java_apirest_2026.models.dao.AccountEntity;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface AccountService {
    AccountEntity save(AccountEntity account);
    ResponseEntity<AccountEntity> findById(Long id);
    List<AccountEntity> findAll();
}
