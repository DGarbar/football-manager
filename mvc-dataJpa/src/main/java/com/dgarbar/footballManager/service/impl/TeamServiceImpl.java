package com.dgarbar.footballManager.service.impl;

import com.dgarbar.footballManager.model.dto.PlayerDto;
import com.dgarbar.footballManager.model.dto.TeamDto;
import com.dgarbar.footballManager.model.entity.Player;
import com.dgarbar.footballManager.model.entity.Team;
import com.dgarbar.footballManager.model.mapper.InnerTeamDtoMapper;
import com.dgarbar.footballManager.model.mapper.PlayerDtoMapper;
import com.dgarbar.footballManager.model.mapper.TeamDtoMapper;
import com.dgarbar.footballManager.repo.PlayerRepository;
import com.dgarbar.footballManager.repo.TeamRepository;
import com.dgarbar.footballManager.service.TeamService;
import com.dgarbar.footballManager.service.exception.EntityNotExistException;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TeamServiceImpl implements TeamService {

	private PlayerRepository playerRepository;
	private TeamRepository teamRepository;

	private TeamDtoMapper teamDtoMapper;

	public TeamServiceImpl(PlayerRepository playerRepository,
		TeamRepository teamRepository,
		TeamDtoMapper teamDtoMapper) {
		this.playerRepository = playerRepository;
		this.teamRepository = teamRepository;
		this.teamDtoMapper = teamDtoMapper;
	}

	@Transactional(readOnly = true)
	@Override
	public List<TeamDto> getAllTeams() {
		List<Team> teams = teamRepository.findAll();
		return teamDtoMapper.toDtoList(teams);
	}

	@Transactional(readOnly = true)
	@Override
	public TeamDto getTeamById(Long id) {
		return teamRepository.findById(id)
			.map(teamDtoMapper::toDto)
			.orElseThrow(EntityNotExistException::new);
	}

	@Override
	public void assignCaptainToTeam(Long teamId, PlayerDto captain) {
		Team team = teamRepository.findById(teamId)
			.orElseThrow(EntityNotExistException::new);
		Player player = playerRepository.findById(captain.getId())
			.orElseThrow(EntityNotExistException::new);
		team.setCaptain(player);
	}

}
