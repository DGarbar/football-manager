package com.dgarbar.footballManager.repo;

import static org.junit.Assert.assertNotNull;

import com.dgarbar.footballManager.config.JpaConfig;
import com.dgarbar.footballManager.config.RootConfig;
import com.dgarbar.footballManager.config.WebConfig;
import com.dgarbar.footballManager.model.entity.Player;
import com.dgarbar.footballManager.model.entity.Team;
import com.dgarbar.footballManager.service.PlayerService;
import com.dgarbar.footballManager.service.impl.PlayerServiceImpl;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class PlayerRepositoryTest {

	@Autowired
	private PlayerService playerService;

	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	private TeamRepository teamRepository;

}