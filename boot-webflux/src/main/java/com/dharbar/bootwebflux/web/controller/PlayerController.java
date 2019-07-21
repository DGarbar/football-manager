package com.dharbar.bootwebflux.web.controller;

import com.dharbar.bootwebflux.model.dto.PlayerDto;
import com.dharbar.bootwebflux.service.PlayerService;
import java.net.URI;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/players")
public class PlayerController {

	private PlayerService playerService;

	public PlayerController(PlayerService playerService) {
		this.playerService = playerService;
	}

	@GetMapping
	public Flux<PlayerDto> getAll() {
		return playerService.getAllPlayers();
	}

	@GetMapping("/{id}")
	public Mono<PlayerDto> getById(@PathVariable String id) {
		return playerService.getPlayerById(id);
	}

	@PostMapping
	public Mono<ResponseEntity<PlayerDto>> create(@RequestBody PlayerDto playerDto) {
		return playerService.createPlayer(playerDto)
			.map(p -> ResponseEntity.created(URI.create("/profiles/" + p.getId()))
				.contentType(MediaType.APPLICATION_JSON)
				.build());
	}

	@DeleteMapping("/{id}")
	public Mono<PlayerDto> delete(@PathVariable String id) {
		return playerService.delete(id);
	}

}
