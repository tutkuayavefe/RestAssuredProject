
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*; 
import static io.restassured.RestAssured.*;

public class FakeLocalRestApi {

	
	@Test
	public void test_get() {
		
		baseURI = "http://localhost:3000/";
		
		given().
			param("name", "Automation").
			get("/topic").
		then().
			statusCode(200).
			log().all();
		
	}
	
	
	

	@Test
	public void test_post() {
		
		
		JSONObject request = new JSONObject();
		request.put("firstName", "Tom");
		request.put("lastName", "Muller");
		request.put("subjectId", "1");
		
		
		baseURI = "http://localhost:3000/";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			header("Conten-Type", "application/json").
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			log().all();
		
	}
	

	@Test
	public void test_patch() {
		
		
		JSONObject request = new JSONObject();
	
		request.put("lastName", "Jo");
		
		
		
		baseURI = "http://localhost:3000/";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			header("Conten-Type", "application/json").
			body(request.toJSONString()).
		when().
			patch("/users/4").
		then().
			statusCode(200).
			log().all();
		
	}
	
	

	@Test
	public void test_put() {
		
		
		JSONObject request = new JSONObject();
		request.put("firstName", "Mary");
		request.put("lastName", "Muller");
		request.put("subjectId", "1");
		
		
		baseURI = "http://localhost:3000/";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			header("Conten-Type", "application/json").
			body(request.toJSONString()).
		when().
			put("/users/4").
		then().
			statusCode(200).
			log().all();
		
	}
	
	
	
	@Test
	public void test_delete() {
		
		 
		baseURI = "http://localhost:3000/";
		
		 
		when().
			put("/users/4").
		then().
			statusCode(200); 
		
	}
}
