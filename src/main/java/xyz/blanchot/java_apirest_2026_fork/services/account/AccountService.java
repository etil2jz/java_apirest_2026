package xyz.blanchot.java_apirest_2026_fork.services.account;

import xyz.blanchot.java_apirest_2026_fork.models.dao.AccountEntity;

import java.util.List;

public interface AccountService {

	AccountEntity save(AccountEntity account);

	AccountEntity findById(Long id);

	List<AccountEntity> findAll();

}
