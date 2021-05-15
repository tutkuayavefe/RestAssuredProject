import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*; 
import static io.restassured.RestAssured.*;

public class TestPost {
	
	@Test
	public void test_post() {
//		
//		Map <String, Object> map = new HashMap<String, Object>() ;
//		
//		map.put("name", "tutku");
//		map.put("job", "qa engineer");
//		System.out.println(map);
		
		
		JSONObject request = new JSONObject();
		request.put("name", "tutku");
		request.put("job", "qa engineer");

		System.out.println(request);
		System.out.println(request.toJSONString());
		
		given().
			header("Conten-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("https://reqres.in/api/users").
		then().
			statusCode(201);

	}
	
	@Test
	public void test_put() {

		
		JSONObject request = new JSONObject();
		request.put("name", "tutku");
		request.put("job", "qa engineer");

		System.out.println(request);
		System.out.println(request.toJSONString());
		
		given().
			header("Conten-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("https://reqres.in/api/users/2").
		then().
			statusCode(200).
			log().all();

	}
	
	
	@Test
	public void test_patch() {

		
		JSONObject request = new JSONObject();
		request.put("name", "tutku");
		request.put("job", "qa engineer");

		System.out.println(request);
		System.out.println(request.toJSONString());
		
		given().
			header("Conten-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("https://reqres.in/api/users/2").
		then().
			statusCode(200).
			log().all();

	}
	
	@Test
	public void test_delete() {
		
		when().
			delete("https://reqres.in/api/users/2").
		then().
			statusCode(204).
			log().all();

	}

}
