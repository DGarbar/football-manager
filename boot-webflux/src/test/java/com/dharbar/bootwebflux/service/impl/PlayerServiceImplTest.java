package com.dharbar.bootwebflux.service.impl;

import com.dharbar.bootwebflux.model.dto.PlayerDto;
import com.dharbar.bootwebflux.model.entity.Player;
import com.dharbar.bootwebflux.model.mapper.PlayerDtoMapper;
import com.dharbar.bootwebflux.repo.PlayerRepository;
import com.dharbar.bootwebflux.service.PlayerService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@Log4j2
@DataMongoTest
@Import({PlayerServiceImpl.class, PlayerDtoMapper.class})
class PlayerServiceImplTest {

	private final PlayerService service;
	private final PlayerRepository repository;
	private final PlayerDtoMapper dtoMapper;

	@Autowired
	PlayerServiceImplTest(
		PlayerServiceImpl service,
		PlayerRepository repository,
		PlayerDtoMapper dtoMapper) {
		this.service = service;
		this.repository = repository;
		this.dtoMapper = dtoMapper;
	}


	@Test
	void getAllPlayers() {
		final Flux<Player> saved = repository.saveAll(
			Flux.just(Player.of(null, "firs", "flast"),
				Player.of(null, "second", "fsecondf"),
				Player.of(null, "third", "fthird")));

		final Flux<Player> playerFlux = service.getAllPlayers().thenMany(saved);

		StepVerifier
			.create(playerFlux)
			.expectNext(Player.of(null, "firs", "flast"))
			.expectNext(Player.of(null, "second", "fsecondf"))
			.expectNext(Player.of(null, "third", "fthird"))
			.verifyComplete();
	}

	@Test
	void getPlayerById() {
		service.getAllPlayers().doOnNext(log::info).blockLast();
	}

	@Test
	void delete() {
	}

	@Test
	void createPlayer() {
		Mono<PlayerDto> profileMono = service.createPlayer(PlayerDto.of(null, "f", "l"));

		StepVerifier
			.create(profileMono)
			.expectNextMatches(saved -> StringUtils.hasText(saved.getId()))
			.verifyComplete();
	}
}