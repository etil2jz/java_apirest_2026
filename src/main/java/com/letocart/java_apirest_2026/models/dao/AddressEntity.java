package com.letocart.java_apirest_2026.models.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "address")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddressEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long addressId;

	private String address;

	@OneToOne(mappedBy = "address")
	private AccountEntity account;
}
