package com.dharbar.bootwebflux.model.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(of = {"firstName", "lastName"})
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Setter
@Getter
@Document(value = "player")
public class Player {

	@Id
	private String id;

	private String firstName;
	private String lastName;
}
