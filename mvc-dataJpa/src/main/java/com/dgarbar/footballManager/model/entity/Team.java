package com.dgarbar.footballManager.model.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Team {

	@Id
	@GeneratedValue
	private Long id;

	@NaturalId
	private String name;

	//Eagerly -> Lazy ??
	@JoinColumn(name = "captain_id")
	@OneToOne(optional = false)
	private Player captain;

//	@Setter(AccessLevel.PRIVATE)
//	@OneToMany(mappedBy = "team")
//	private Set<Player> playerSet = new HashSet<>();
//
//	public void addPlayer(Player player) {
//		playerSet.add(player);
//		player.setTeam(this);
//	}
//
//	public void removePlayer(Player player) {
//		playerSet.remove(player);
//		player.setTeam(null);
//	}
//
//	public void setCaptain(Player player){
//		player.getTeam().removePlayer(player);
//		captain = player;
//		addPlayer(player);
//	}

}
