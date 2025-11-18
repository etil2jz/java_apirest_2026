package xyz.blanchot.java_apirest_2026_fork.models.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateOrder {

	@NotNull
	private Long accountId;

	@NotEmpty
	private List<Long> productIds;

}
