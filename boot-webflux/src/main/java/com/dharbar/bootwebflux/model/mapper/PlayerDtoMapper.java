package com.dharbar.bootwebflux.model.mapper;

import com.dharbar.bootwebflux.model.dto.PlayerDto;
import com.dharbar.bootwebflux.model.entity.Player;
import org.springframework.stereotype.Component;

@Component
public class PlayerDtoMapper implements DtoMapper<PlayerDto, Player> {

	@Override
	public PlayerDto toDto(Player player) {
		return PlayerDto.builder()
			.id(player.getId())
			.firstName(player.getFirstName())
			.lastName(player.getLastName())
			.build();
	}

	public Player toEntity(PlayerDto playerDto) {
		Player player = new Player();
		player.setFirstName(playerDto.getFirstName());
		player.setLastName(playerDto.getLastName());
		return player;
	}
}
