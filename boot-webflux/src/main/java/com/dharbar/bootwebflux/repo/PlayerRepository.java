package com.dharbar.bootwebflux.repo;

import com.dharbar.bootwebflux.model.entity.Player;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PlayerRepository extends ReactiveMongoRepository<Player, String> {

}
