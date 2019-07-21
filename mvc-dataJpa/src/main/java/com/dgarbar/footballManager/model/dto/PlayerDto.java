package com.dgarbar.footballManager.model.dto;

import com.dgarbar.footballManager.model.entity.Position;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDto {

	private Long id;

	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull
	private Position position;
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthday;

	private TeamDto team;
}
