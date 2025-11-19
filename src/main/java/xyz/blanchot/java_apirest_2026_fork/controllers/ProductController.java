package xyz.blanchot.java_apirest_2026_fork.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.blanchot.java_apirest_2026_fork.models.dao.ProductEntity;
import xyz.blanchot.java_apirest_2026_fork.models.dto.CreateProduct;
import xyz.blanchot.java_apirest_2026_fork.models.mappers.ProductMapper;
import xyz.blanchot.java_apirest_2026_fork.services.product.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService service;

	private final ProductMapper mapper;

	@PostMapping
	public ProductEntity create(@RequestBody @Valid CreateProduct dto) {
		return service.save(mapper.toEntity(dto));
	}

	@GetMapping("/{productId}")
	public ResponseEntity<ProductEntity> findById(@PathVariable Long productId) {
		return ResponseEntity.ok(service.findById(productId));
	}

	@GetMapping
	public List<ProductEntity> findAll() {
		return service.findAll();
	}

}
