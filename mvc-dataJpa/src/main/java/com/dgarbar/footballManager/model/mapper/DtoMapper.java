package com.dgarbar.footballManager.model.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface DtoMapper <DTO, ENTITY>{

	DTO toDto(ENTITY entity);

	default List<DTO> toDtoList(Collection<ENTITY> entities) {
		return entities.stream()
			.map(this::toDto)
			.collect(Collectors.toList());
	}
}
