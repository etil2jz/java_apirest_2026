package xyz.blanchot.java_apirest_2026_fork.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.blanchot.java_apirest_2026_fork.models.dao.OrdersEntity;
import xyz.blanchot.java_apirest_2026_fork.models.dto.CreateOrder;
import xyz.blanchot.java_apirest_2026_fork.services.orders.OrdersServiceImp;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrdersController {

	private final OrdersServiceImp service;

	@PostMapping
	public OrdersEntity create(@RequestBody @Valid CreateOrder dto) {
		return service.createOrder(dto.getAccountId(), dto.getProductIds());
	}

}
