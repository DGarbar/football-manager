package com.dharbar.bootwebflux.model.mapper;

import com.dharbar.bootwebflux.model.dto.PlayerDto;
import com.dharbar.bootwebflux.model.dto.TeamDto;
import com.dharbar.bootwebflux.model.entity.Team;
import org.springframework.stereotype.Component;

@Component
public class TeamDtoMapper implements DtoMapper<TeamDto, Team> {

	private PlayerDtoMapper playerDtoMapper;

	public TeamDtoMapper(PlayerDtoMapper playerDtoMapper) {
		this.playerDtoMapper = playerDtoMapper;
	}

	@Override
	public TeamDto toDto(Team team) {
		return TeamDto.builder()
			.id(team.getId())
			.name(team.getName())
			.captain(getCaptain(team))
			.build();
	}

	private PlayerDto getCaptain(Team team) {
		return playerDtoMapper.toDto(team.getCaptain());
	}
}
