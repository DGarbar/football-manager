package com.dgarbar.footballManager.model.mapper;

import com.dgarbar.footballManager.model.dto.PlayerDto;
import com.dgarbar.footballManager.model.dto.TeamDto;
import com.dgarbar.footballManager.model.entity.Team;
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
