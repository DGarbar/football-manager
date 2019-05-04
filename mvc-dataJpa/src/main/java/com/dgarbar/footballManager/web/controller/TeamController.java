package com.dgarbar.footballManager.web.controller;

import com.dgarbar.footballManager.model.dto.PlayerDto;
import com.dgarbar.footballManager.model.dto.TeamDto;
import com.dgarbar.footballManager.service.PlayerService;
import com.dgarbar.footballManager.service.TeamService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teams")
public class TeamController {

	private PlayerService playerService;
	private TeamService teamService;

	public TeamController(PlayerService playerService,
		TeamService teamService) {
		this.playerService = playerService;
		this.teamService = teamService;
	}

	@GetMapping
	public List<TeamDto> getAll() {
		return teamService.getAllTeams();
	}

	@GetMapping("/{id}")
	public TeamDto getTeam(@PathVariable Long id) {
		return teamService.getTeamById(id);
	}

	@GetMapping("/{id}/players")
	public List<PlayerDto> getPlayersByTeam(@PathVariable Long id) {
		return playerService.getPlayersByTeamId(id);
	}


	@GetMapping("/{id}/captain")
	public PlayerDto getCaptainByTeam(@PathVariable Long id) {
		return playerService.getCaptainByTeamId(id);
	}


	@PostMapping("/{id}/captain")
	public void setCaptain(@PathVariable Long id, @RequestBody PlayerDto captain) {
		teamService.assignCaptainToTeam(id,captain);
	}

	//Mb Patch or Put(but no idempotent ???
	@PostMapping("/{id}/addPlayer")
	public void addPlayer(@PathVariable Long id, @RequestBody PlayerDto player) {
		teamService.addPlayerToTeam(id,player);
	}

}
