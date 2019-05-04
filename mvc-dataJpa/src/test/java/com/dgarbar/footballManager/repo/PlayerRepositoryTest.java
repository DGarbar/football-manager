package com.dgarbar.footballManager.repo;

import com.dgarbar.footballManager.config.RootConfig;
import com.dgarbar.footballManager.config.WebConfig;
import org.junit.Test;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

@SpringJUnitWebConfig(classes = {RootConfig.class, WebConfig.class})
public class PlayerRepositoryTest {

	@Test
	public void testFindPlayerByReferenceTeam() {

	}
}