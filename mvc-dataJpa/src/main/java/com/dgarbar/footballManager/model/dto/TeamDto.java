package com.dgarbar.footballManager.model.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeamDto {

	private Long id;

	private String name;

	private PlayerDto captain;

//	private List<PlayerDto> playerSet = new ArrayList<>();
}

