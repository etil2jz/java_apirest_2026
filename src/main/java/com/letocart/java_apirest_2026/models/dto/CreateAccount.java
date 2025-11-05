package com.letocart.java_apirest_2026.models.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateAccount {

	@NotBlank
	private String username;

	@NotBlank
	private String password;

	@NotBlank
	private String description;

	@NotBlank
	private String address;

}
