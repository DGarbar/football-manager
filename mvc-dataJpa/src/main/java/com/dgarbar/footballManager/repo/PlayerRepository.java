package com.dgarbar.footballManager.repo;

import com.dgarbar.footballManager.model.entity.Player;
import com.dgarbar.footballManager.model.entity.Team;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player,Long> {

	Optional<Player> findByTeam(Team team);
}
