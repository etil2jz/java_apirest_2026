package xyz.blanchot.java_apirest_2026_fork.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProduct {

	@NotBlank
	private String name;

	@Positive
	private float price;

}
