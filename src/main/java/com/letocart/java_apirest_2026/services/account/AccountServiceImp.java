package com.letocart.java_apirest_2026.services.account;

import com.letocart.java_apirest_2026.configuration.exeption.types.NotFoundException;
import com.letocart.java_apirest_2026.models.dao.AccountEntity;
import com.letocart.java_apirest_2026.repositories.AccountJPARepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImp  implements AccountService {

    private final AccountJPARepository repository;

    public AccountEntity save(AccountEntity account) {
        return repository.save(account);
    }

    public AccountEntity findById(Long id) {
        Optional<AccountEntity> account = repository.findById(id);
        if (account.isEmpty()){
            throw new NotFoundException("Account not found");
        }
        return account.get();
    }

    public List<AccountEntity> findAll() {
        return repository.findAll();
    }
}
