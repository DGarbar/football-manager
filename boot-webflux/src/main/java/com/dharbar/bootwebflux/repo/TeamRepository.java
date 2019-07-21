package com.dharbar.bootwebflux.repo;

import com.dharbar.bootwebflux.model.entity.Team;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TeamRepository extends ReactiveMongoRepository<Team, String> {

}
