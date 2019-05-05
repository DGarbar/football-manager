package com.dgarbar.footballManager.model.entity;

import java.time.LocalDate;
import javax.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "player")
public class Player {
	@Id
	@SequenceGenerator(name = "player_seq", sequenceName = "player_seq", allocationSize = 1 )
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="player_seq")
	private Long id;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(nullable = false)
	@Enumerated(value = EnumType.STRING)
	private Position position;

	@Column(nullable = false)
	private LocalDate birthday;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "team_id")
	private Team team;
}
