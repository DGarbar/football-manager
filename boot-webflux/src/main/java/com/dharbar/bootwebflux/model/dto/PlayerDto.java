package com.dharbar.bootwebflux.model.dto;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class PlayerDto {

	private String id;

	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
}
