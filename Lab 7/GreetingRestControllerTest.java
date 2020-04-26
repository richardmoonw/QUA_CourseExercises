package mx.tec.lab.rest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
public class GreetingRestControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void givenARequest_WhenEmptyName_thenHelloWorld() throws Exception {
		this.mockMvc.perform(get("/greeting"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("content", equalTo("Hello, World!")));
	}
	
	@Test
	public void givenARequest_WhenProvidedName_thenHelloName() throws Exception {
		this.mockMvc.perform(get("/greeting?name=Jon"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("content", equalTo("Hello, Jon!")));
	}
	
	@Test
	public void givenARequest_WhenNullName_thenHelloWorld() throws Exception {
		this.mockMvc.perform(get("/greeting?name="))
			.andExpect(status().isOk())
			.andExpect(jsonPath("content", equalTo("Hello, World!")));
	}
	
	@Test
	public void givenARequest_WhenWrongURL_thenError404() throws Exception {
		this.mockMvc.perform(get("/greting"))
			.andExpect(status().isNotFound());
	}
	
	@Test
	public void givenARequest_WhenEmptyName_thenGoodbyeWoody() throws Exception {
		this.mockMvc.perform(get("/goodbye"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("content", equalTo("Goodbye Woody, nice to meet you")));
	}
	
	@Test
	public void givenARequest_WhenProvidedName_thenGoodbyeName() throws Exception {
		this.mockMvc.perform(get("/goodbye?name=Cersei"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("content", equalTo("Goodbye Cersei, nice to meet you")));
	}
	
	@Test
	public void givenARequest_WhenNullName_thenGoodbyeWoody() throws Exception {
		this.mockMvc.perform(get("/goodbye?name="))
			.andExpect(status().isOk())
			.andExpect(jsonPath("content", equalTo("Goodbye Woody, nice to meet you")));
	}
}
