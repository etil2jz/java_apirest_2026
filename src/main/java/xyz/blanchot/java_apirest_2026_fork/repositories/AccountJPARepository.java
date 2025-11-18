package xyz.blanchot.java_apirest_2026_fork.repositories;

import xyz.blanchot.java_apirest_2026_fork.models.dao.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountJPARepository extends JpaRepository<AccountEntity, Long> {

	Optional<AccountEntity> findByUsername(String username);

}
