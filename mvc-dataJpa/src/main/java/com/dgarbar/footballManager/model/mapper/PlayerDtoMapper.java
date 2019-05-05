package com.dgarbar.footballManager.model.mapper;

import com.dgarbar.footballManager.model.dto.PlayerDto;
import com.dgarbar.footballManager.model.entity.Player;
import org.springframework.stereotype.Component;

@Component
public class PlayerDtoMapper implements DtoMapper<PlayerDto, Player> {

	@Override
	public PlayerDto toDto(Player player) {
		return PlayerDto.builder()
			.id(player.getId())
			.birthday(player.getBirthday())
			.firstName(player.getFirstName())
			.lastName(player.getLastName())
			.position(player.getPosition())
			.build();
	}

	public Player toEntity(PlayerDto playerDto) {
		Player player = new Player();
		player.setBirthday(playerDto.getBirthday());
		player.setFirstName(playerDto.getFirstName());
		player.setLastName(playerDto.getLastName());
		player.setPosition(playerDto.getPosition());
		return player;
	}
}
