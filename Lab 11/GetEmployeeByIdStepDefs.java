package mx.tec.lab.stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class GetEmployeeByIdStepDefs {
	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();
	ResponseEntity<String> response = null;
	
	@When("the client calls \\/users\\/{int}")
	public void the_client_calls_users(int userId) {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		response = restTemplate.exchange("https://reqres.in/api/users/" + userId,
				HttpMethod.GET, entity, String.class);
	}
	
	@Then("the client receives status code of {int}")
	public void the_client_receives_status_code_of(int statusCode) {
		assertEquals(statusCode, response.getStatusCodeValue());
	}
	
	@And("the client receives user first name {string}")
	public void the_client_receives_user_first_name_of(String userFirstName) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		// readTree(String content): Method to deserialize JSON content as tree expressed using set of JsonNode instances.
		JsonNode root = mapper.readTree(response.getBody());
		assertEquals(userFirstName, root.path("data").path("first_name").asText());
	}
}
