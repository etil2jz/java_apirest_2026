package xyz.blanchot.java_apirest_2026_fork.services.product;

import xyz.blanchot.java_apirest_2026_fork.models.dao.ProductEntity;

import java.util.List;

public interface ProductService {

	ProductEntity save(ProductEntity product);

	List<ProductEntity> findAll();

	ProductEntity findById(Long id);

}
