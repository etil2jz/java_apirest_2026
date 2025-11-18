package xyz.blanchot.java_apirest_2026_fork.models.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "orders_details")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrdersDetailsEntity {

	@EmbeddedId
	private OrdersDetailsId ordersDetailsId;

	@MapsId("ordersId")
	@ManyToOne
	@JoinColumn(name = "orders_id")
	@JsonBackReference
	private OrdersEntity orders;

	@MapsId("productId")
	@ManyToOne
	@JoinColumn(name = "product_id")
	private ProductEntity product;

}
