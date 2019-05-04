package com.dgarbar.footballManager.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Team {

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true, nullable = false)
	private String name;

	@JoinColumn(name = "captain_player_id")
	@OneToOne(optional = false)
	private Player captain;

	@Setter(AccessLevel.PRIVATE)
	@OneToMany(mappedBy = "team")
	private Set<Player> playerSet = new HashSet<>();

	public void addPlayer(Player player) {
		playerSet.add(player);
		player.setTeam(this);
	}

	public void removePlayer(Player player) {
		playerSet.remove(player);
		player.setTeam(null);
	}

	public void setCaptain(Player player){
		captain = player;
		addPlayer(player);
	}

}
