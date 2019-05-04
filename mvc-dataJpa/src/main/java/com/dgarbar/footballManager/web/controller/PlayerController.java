package com.dgarbar.footballManager.web.controller;

import com.dgarbar.footballManager.model.entity.Player;
import com.dgarbar.footballManager.repo.PlayerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players")
public class PlayerController {

	private PlayerRepository playerRepository;

	public PlayerController(  PlayerRepository playerRepository) {
		this.playerRepository = playerRepository;
	}

	@GetMapping
	public List<Player> getAll(){
		return playerRepository.findAll();
	}

	@GetMapping("/get")
	public Player getAall(){
		return playerRepository.findAll().get(0);
	}
}
