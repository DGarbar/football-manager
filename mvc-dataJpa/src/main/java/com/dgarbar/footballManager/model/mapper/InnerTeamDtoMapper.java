package com.dgarbar.footballManager.model.mapper;

import com.dgarbar.footballManager.model.dto.PlayerDto;
import com.dgarbar.footballManager.model.dto.TeamDto;
import com.dgarbar.footballManager.model.entity.Player;
import com.dgarbar.footballManager.model.entity.Team;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class InnerTeamDtoMapper implements DtoMapper<TeamDto, Team> {

	private PlayerDtoMapper playerDtoMapper;

	public InnerTeamDtoMapper(PlayerDtoMapper playerDtoMapper) {
		this.playerDtoMapper = playerDtoMapper;
	}

	@Override
	public TeamDto toDto(Team team) {
		return TeamDto.builder()
			.id(team.getId())
			.name(team.getName())
			.captain(getCaptain(team))
//			.playerSet(getPlayers(team))
			.build();
	}

//	private List<PlayerDto> getPlayers(Team team) {
//		Set<Player> playerSet = team.getPlayerSet();
//		return playerDtoMapper.toDtoList(playerSet);
//	}

	private PlayerDto getCaptain(Team team) {
		return playerDtoMapper.toDto(team.getCaptain());
	}
}
