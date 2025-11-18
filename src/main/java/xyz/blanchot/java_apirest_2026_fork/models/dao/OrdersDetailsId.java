package xyz.blanchot.java_apirest_2026_fork.models.dao;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
public class OrdersDetailsId implements Serializable {

	private Long ordersId;
	private Long productId;

}
