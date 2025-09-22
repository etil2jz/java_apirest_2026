package com.letocart.java_apirest_2026.services.account;

import com.letocart.java_apirest_2026.models.dao.AccountEntity;
import java.util.List;

public interface AccountService {
    AccountEntity save(AccountEntity account);
    AccountEntity findById(Long id);
    List<AccountEntity> findAll();
}
