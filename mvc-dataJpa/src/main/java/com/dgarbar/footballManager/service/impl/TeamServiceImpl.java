package com.dgarbar.footballManager.service.impl;

import com.dgarbar.footballManager.model.dto.PlayerDto;
import com.dgarbar.footballManager.model.dto.TeamDto;
import com.dgarbar.footballManager.repo.TeamRepository;
import com.dgarbar.footballManager.service.TeamService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {

	private TeamRepository teamRepository;

	@Override
	public List<TeamDto> getAllTeams() {
		return null;
	}

	@Override
	public TeamDto getTeamById(Long id) {
		return null;
	}

	@Override
	public List<PlayerDto> getPlayersByTeamId(Long id) {
		return null;
	}

	@Override
	public PlayerDto getCaptainByTeamId(Long id) {
		return null;
	}

	@Override
	public void assignCaptainToTeam(Long id, PlayerDto captain) {

	}

	@Override
	public void addPlayerToTeam(Long id, PlayerDto player) {

	}
}
