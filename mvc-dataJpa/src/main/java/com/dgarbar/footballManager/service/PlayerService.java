package com.dgarbar.footballManager.service;

import com.dgarbar.footballManager.model.dto.PlayerDto;
import java.util.List;

public interface PlayerService {

	List<PlayerDto> getAllPlayers();

	PlayerDto getPlayerById(Long id);

	PlayerDto getCaptainByTeamId(Long teamId);

	List<PlayerDto> getPlayersByTeamId(Long teamId);
}
