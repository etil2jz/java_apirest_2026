package com.letocart.java_apirest_2026.models.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "account")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;

    private String username;

    private String description;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "addressId")
	private AddressEntity address;

	@OneToMany(mappedBy = "account")
	private List<OrdersEntity> orders;
}
