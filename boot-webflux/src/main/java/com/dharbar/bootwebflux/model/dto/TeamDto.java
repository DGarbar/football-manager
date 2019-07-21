package com.dharbar.bootwebflux.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeamDto {

	private String id;

	private String name;

	private PlayerDto captain;

//	private List<PlayerDto> playerSet = new ArrayList<>();
}

