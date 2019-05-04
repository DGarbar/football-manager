package com.dgarbar.footballManager.model.dto;

import com.dgarbar.footballManager.model.entity.Position;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDto {

	private Long id;

	private String firstName;

	private String lastName;

	private Position position;

	private LocalDate birthday;

	private TeamDto team;
}
