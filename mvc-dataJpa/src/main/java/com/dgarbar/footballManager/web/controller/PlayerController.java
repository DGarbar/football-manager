package com.dgarbar.footballManager.web.controller;

import com.dgarbar.footballManager.model.dto.PlayerDto;
import com.dgarbar.footballManager.model.entity.Player;
import com.dgarbar.footballManager.repo.PlayerRepository;
import com.dgarbar.footballManager.service.PlayerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players")
public class PlayerController {

	private PlayerService playerService;

	public PlayerController(  PlayerService playerService) {
		this.playerService = playerService;
	}

	@GetMapping
	public List<PlayerDto> getAll(){
		return playerService.getAllPlayers();
	}
}
