import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DataDrivenExample {

	
	@DataProvider(name = "DataToPost")
		public Object [][] dataToPost(){
			Object [][] data = new Object [2][3];
			
//			
//			data[0][0] = "Albert";
//			data[0][1] = "A";
//			data[0][2] = 2;
//			
//			
//			data[1][0] = "John";
//			data[1][1] = "J";
//			data[1][2] = 1;
//			
//			
//			return data;
			
			return new Object [][] {
				{"Henry", "H", 1},
				{"Joe","J",2}
			};
					
	}
	
	
	
	@Test (dataProvider = "DataToPost")
	public void test_post(String firstName, String lastName, int subjectId) {
		
		
		JSONObject request = new JSONObject();
		request.put("firstName", firstName);
		request.put("lastName", lastName);
		request.put("subjectId", subjectId);
		
		
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
}
