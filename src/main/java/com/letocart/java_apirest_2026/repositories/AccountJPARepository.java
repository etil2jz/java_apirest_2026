package com.letocart.java_apirest_2026.repositories;

import com.letocart.java_apirest_2026.models.dao.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountJPARepository extends JpaRepository<AccountEntity, Long> {

	Optional<AccountEntity> findByUsername(String username);

}
