package com.dharbar.bootwebflux.service;

import com.dharbar.bootwebflux.model.dto.PlayerDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlayerService {

	Flux<PlayerDto> getAllPlayers();

	Mono<PlayerDto> getPlayerById(String id);

//	PlayerDto getCaptainByTeamId(String teamId);

//	List<PlayerDto> getPlayersByTeamId(String teamId);

	Mono<PlayerDto> delete(String id);

	Mono<PlayerDto> createPlayer(PlayerDto playerDto);

//	void addPlayerToTeam(String teamId, PlayerDto playerDto);
}
