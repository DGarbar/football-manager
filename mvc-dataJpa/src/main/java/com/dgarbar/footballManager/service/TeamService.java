package com.dgarbar.footballManager.service;

import com.dgarbar.footballManager.model.dto.PlayerDto;
import com.dgarbar.footballManager.model.dto.TeamDto;
import java.util.List;

public interface TeamService {

	List<TeamDto> getAllTeams();

	TeamDto getTeamById(Long id);

	void assignCaptainToTeam(Long id, PlayerDto captain);

	void addPlayerToTeam(Long id, PlayerDto player);
}
