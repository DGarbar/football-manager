package com.dgarbar.footballManager.service.impl;

import com.dgarbar.footballManager.model.dto.PlayerDto;
import com.dgarbar.footballManager.model.entity.Player;
import com.dgarbar.footballManager.model.entity.Team;
import com.dgarbar.footballManager.model.mapper.PlayerDtoMapper;
import com.dgarbar.footballManager.repo.PlayerRepository;
import com.dgarbar.footballManager.repo.TeamRepository;
import com.dgarbar.footballManager.service.PlayerService;
import java.util.List;
import javax.persistence.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class PlayerServiceImpl implements PlayerService {

	private TeamRepository teamRepository;
	private PlayerRepository playerRepository;
	private PlayerDtoMapper playerDtoMapper;

	public PlayerServiceImpl(TeamRepository teamRepository,
		PlayerRepository playerRepository,
		PlayerDtoMapper playerDtoMapper) {
		this.teamRepository = teamRepository;
		this.playerRepository = playerRepository;
		this.playerDtoMapper = playerDtoMapper;
	}

	@Transactional(readOnly = true)
	@Override
	public List<PlayerDto> getAllPlayers() {
		List<Player> players = playerRepository.findAll();
		return playerDtoMapper.toDtoList(players);
	}

	@Transactional(readOnly = true)
	@Override
	public PlayerDto getPlayerById(Long id) {
		return playerRepository.findById(id)
			.map(playerDtoMapper::toDto)
			.orElseThrow(EntityExistsException::new);
	}

	@Transactional(readOnly = true)
	@Override
	public PlayerDto getCaptainByTeamId(Long teamId) {
		return teamRepository.findById(teamId)
			.map(Team::getCaptain)
			.map(playerDtoMapper::toDto)
			.orElseThrow(EntityExistsException::new);
	}

	@Transactional(readOnly = true)
	@Override
	public List<PlayerDto> getPlayersByTeamId(Long teamId) {
		List<Player> players = playerRepository.findByTeamId(teamId);
		return playerDtoMapper.toDtoList(players);
	}

	public void addPlayerToTeam(Long id, PlayerDto playerDto) {
		Team team = teamRepository.findById(id)
			.orElseThrow(EntityExistsException::new);
		Player playerNew = playerDtoMapper.toEntity(playerDto);
		playerNew.setTeam(team);
		playerRepository.save(playerNew);
	}
}

