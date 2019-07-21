package com.dharbar.bootwebflux.service.publishers;

import com.dharbar.bootwebflux.model.dto.PlayerDto;
import org.springframework.context.ApplicationEvent;

public class PlayerCreatedEvent extends ApplicationEvent {

	public PlayerCreatedEvent(PlayerDto source) {
		super(source);
	}
}
