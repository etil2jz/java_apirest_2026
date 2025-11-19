package xyz.blanchot.java_apirest_2026_fork.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateNotice {

	@NotNull
	private Long accountId;

	@NotNull
	private Long productId;

	@NotBlank
	private String userReview;

}
