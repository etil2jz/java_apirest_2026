package com.letocart.java_apirest_2026.models.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "notice")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NoticeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long noticeId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "orders_id")
	private OrdersEntity orders;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id")
	private AccountEntity account;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id")
	private ProductEntity product;

	private String userReview;
}
