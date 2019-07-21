package com.dharbar.bootwebflux.service.impl;

import com.dharbar.bootwebflux.model.dto.PlayerDto;
import com.dharbar.bootwebflux.model.entity.Player;
import com.dharbar.bootwebflux.model.mapper.PlayerDtoMapper;
import com.dharbar.bootwebflux.repo.PlayerRepository;
import com.dharbar.bootwebflux.service.PlayerService;
import com.dharbar.bootwebflux.service.publishers.PlayerCreatedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlayerServiceImpl implements PlayerService {

	private final ApplicationEventPublisher publisher;
	private PlayerRepository playerRepository;
	private PlayerDtoMapper playerDtoMapper;

	public PlayerServiceImpl(
		ApplicationEventPublisher publisher,
		PlayerRepository playerRepository,
		PlayerDtoMapper playerDtoMapper) {
		this.publisher = publisher;
		this.playerRepository = playerRepository;
		this.playerDtoMapper = playerDtoMapper;
	}

	@Override
	public Flux<PlayerDto> getAllPlayers() {
		return playerRepository.findAll()
			.map(playerDtoMapper::toDto);
	}

	@Override
	public Mono<PlayerDto> getPlayerById(String id) {
		return playerRepository.findById(id)
			.map(playerDtoMapper::toDto);
	}

	@Override
	public Mono<PlayerDto> delete(String id) {
		return playerRepository
			.findById(id)
			.flatMap(p -> this.playerRepository.deleteById(p.getId()).thenReturn(p))
			.map(playerDtoMapper::toDto);
	}

	@Override
	public Mono<PlayerDto> createPlayer(PlayerDto playerDto) {
		final Player player = playerDtoMapper.toEntity(playerDto);
		return playerRepository.save(player)
			.map(playerDtoMapper::toDto)
			.doOnSuccess(p -> publisher.publishEvent(new PlayerCreatedEvent(p)));
	}

}

