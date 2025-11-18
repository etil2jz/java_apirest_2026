package xyz.blanchot.java_apirest_2026_fork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.blanchot.java_apirest_2026_fork.models.dao.ProductEntity;

@Repository
public interface ProductJPARepository extends JpaRepository<ProductEntity, Long> {
}
