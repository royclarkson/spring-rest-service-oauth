/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package hello;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author Roy Clarkson
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = Application.class)
public class GreetingControllerTest {

	@Autowired
	WebApplicationContext context;

	@Autowired
	private FilterChainProxy springSecurityFilterChain;

	@InjectMocks
	GreetingController controller;

	private MockMvc mvc;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mvc = MockMvcBuilders.webAppContextSetup(context)
				.addFilter(springSecurityFilterChain)
				.build();
	}

	@Test
	public void greetingUnauthorized() throws Exception {
		// @formatter:off
		mvc.perform(get("/greeting")
				.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isUnauthorized())
			.andExpect(jsonPath("$.error", is("unauthorized")));
		// @formatter:on
	}

	@Test
	@Ignore
	public void greetingAuthorized() throws Exception {
		
		final String data = "password=spring&username=roy&grant_type=password&scope=read%20write&client_secret=123456&client_id=clientapp";

		// @formatter:off
		mvc.perform(post("/oauth/token")
				.accept(MediaType.APPLICATION_JSON)
				.content(data))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.access_token", is("ff16372e-38a7-4e29-88c2-1fb92897f558")))
			.andExpect(jsonPath("$.token_type", is("bearer")))
			.andExpect(jsonPath("$.expires_in", is(43199)))
			.andExpect(jsonPath("$.scope", is("read write")));
		// @formatter:on

		// @formatter:off
//		mvc.perform(get("/greeting")
//				.accept(MediaType.APPLICATION_JSON))
//			.andExpect(status().isOk())
//			.andExpect(jsonPath("$.id", is(1)))
//			.andExpect(jsonPath("$.content", is("Hello, World!")));
		// @formatter:on
	}

}
