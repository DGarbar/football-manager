package com.dgarbar.footballManager.entity;

import java.time.LocalDate;
import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Player {
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	public String firstName;
	@Column(nullable = false)
	public String lastName;

	@Column(nullable = false)
	@Enumerated(value = EnumType.STRING)
	public Position position;

	@Column(nullable = false)
	private LocalDate localDate;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "team_id")
	private Team team;
}
