package xyz.blanchot.java_apirest_2026_fork.models.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long noticeId;

	@ManyToOne
	@JoinColumn(name = "orders_id")
	private OrdersEntity orders;

	@ManyToOne
	@JoinColumn(name = "account_id")
	private AccountEntity account;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private ProductEntity product;

	private String userReview;

}
