package com.dgarbar.footballManager;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.dgarbar.footballManager.config.RootConfig;
import com.dgarbar.footballManager.config.WebConfig;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;

@SpringJUnitWebConfig(classes = {RootConfig.class, WebConfig.class})
@AutoConfigureMockMvc
public class TestProject {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getAllTeams() throws Exception {
		mockMvc.perform(get("/teams"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.[*].id").value(everyItem(notNullValue())));
	}
}
