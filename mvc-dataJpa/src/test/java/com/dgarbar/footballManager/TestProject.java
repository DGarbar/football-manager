package com.dgarbar.footballManager;

import com.dgarbar.footballManager.config.RootConfig;
import com.dgarbar.footballManager.config.WebConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.context.junit4.SpringRunner;

@SpringJUnitWebConfig(classes = {RootConfig.class, WebConfig.class})
public class TestProject {

	@Test
	public void testProjectIsRunnable() {

	}
}
