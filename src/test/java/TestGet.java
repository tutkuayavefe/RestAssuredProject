

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*; 

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
public class TestGet {

	
	@Test
	public void test1() {
		
		given().
			get("https://reqres.in/api/users?page=2")
		.then().
			statusCode(200).
			body("data.id[1]", equalTo(8)).
			log().all().
			body("data.first_name", hasItems("Tobias","Michael"));
		
	}
	
}
