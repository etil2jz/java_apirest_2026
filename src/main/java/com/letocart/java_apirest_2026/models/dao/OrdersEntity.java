package com.letocart.java_apirest_2026.models.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrdersEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ordersId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id")
	private AccountEntity account;
}
