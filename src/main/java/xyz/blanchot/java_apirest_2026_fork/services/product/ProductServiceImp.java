package xyz.blanchot.java_apirest_2026_fork.services.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.blanchot.java_apirest_2026_fork.configuration.exception.types.NotFoundException;
import xyz.blanchot.java_apirest_2026_fork.models.dao.ProductEntity;
import xyz.blanchot.java_apirest_2026_fork.repositories.ProductJPARepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService {

	private final ProductJPARepository repository;

	@Override
	public ProductEntity save(ProductEntity product) {
		return repository.save(product);
	}

	@Override
	public List<ProductEntity> findAll() {
		return repository.findAll();
	}

	@Override
	public ProductEntity findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new NotFoundException("Product not found"));
	}

}
