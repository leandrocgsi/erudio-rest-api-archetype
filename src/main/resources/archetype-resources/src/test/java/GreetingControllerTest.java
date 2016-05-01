#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Base64Utils;
import org.springframework.web.context.WebApplicationContext;

import ${package}.Application;
import ${package}.endpoints.GreetingController;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = Application.class)
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
		mvc = MockMvcBuilders.webAppContextSetup(context).addFilter(springSecurityFilterChain).build();
	}

	@Test
	public void greetingUnauthorized() throws Exception {
		mvc.perform(get("/greeting")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isUnauthorized())
				.andExpect(jsonPath("${symbol_dollar}.error", is("unauthorized")));
	}

	private String getAccessToken(String username, String password) throws Exception {
		String authorization = "Basic "
				+ new String(Base64Utils.encode("clientapp:123456".getBytes()));
		String contentType = MediaType.APPLICATION_JSON + ";charset=UTF-8";

		String content = mvc
				.perform(post("/oauth/token")
								.header("Authorization", authorization)
								.contentType(MediaType.APPLICATION_FORM_URLENCODED)
								.param("username", username)
								.param("password", password)
								.param("grant_type", "password")
								.param("scope", "read write")
								.param("client_id", "clientapp")
								.param("client_secret", "123456"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(contentType))
				.andExpect(jsonPath("${symbol_dollar}.access_token", is(notNullValue())))
				.andExpect(jsonPath("${symbol_dollar}.token_type", is(equalTo("bearer"))))
				.andExpect(jsonPath("${symbol_dollar}.refresh_token", is(notNullValue())))
				.andExpect(jsonPath("${symbol_dollar}.expires_in", is(greaterThan(4000))))
				.andExpect(jsonPath("${symbol_dollar}.scope", is(equalTo("read write"))))
				.andReturn().getResponse().getContentAsString();

		return content.substring(17, 53);
	}

	@Test
	public void greetingAuthorized() throws Exception {
		String accessToken = getAccessToken("roy", "spring");

		mvc.perform(get("/greeting")
				.header("Authorization", "Bearer " + accessToken))
				.andExpect(status().isOk())
				.andExpect(jsonPath("${symbol_dollar}.id", is(1)))
				.andExpect(jsonPath("${symbol_dollar}.content", is("Hello, Roy!")));

		mvc.perform(get("/greeting")
				.header("Authorization", "Bearer " + accessToken))
				.andExpect(status().isOk())
				.andExpect(jsonPath("${symbol_dollar}.id", is(2)))
				.andExpect(jsonPath("${symbol_dollar}.content", is("Hello, Roy!")));

		mvc.perform(get("/greeting")
				.header("Authorization", "Bearer " + accessToken))
				.andExpect(status().isOk())
				.andExpect(jsonPath("${symbol_dollar}.id", is(3)))
				.andExpect(jsonPath("${symbol_dollar}.content", is("Hello, Roy!")));
	}

	@Test
	public void usersEndpointAuthorized() throws Exception {
		mvc.perform(get("/users")
				.header("Authorization", "Bearer " + getAccessToken("roy", "spring")))
				.andExpect(status().isOk())
				.andExpect(jsonPath("${symbol_dollar}", hasSize(3)));
	}

	@Test
	public void usersEndpointAccessDenied() throws Exception {
		mvc.perform(get("/users")
				.header("Authorization", "Bearer " + getAccessToken("craig", "spring")))
				.andExpect(status().is(403));
	}

}
