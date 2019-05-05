package com.dgarbar.footballManager.model.entity;

import javax.persistence.*;
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
	@SequenceGenerator(name = "team_seq", sequenceName = "team_seq", initialValue = 10, allocationSize = 5)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_seq")
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
