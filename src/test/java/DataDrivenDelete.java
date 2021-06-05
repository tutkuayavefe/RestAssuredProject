import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenDelete {

	
	
	
	@DataProvider(name = "DataToDelete")
		public Object []dataToDelete(){
		
			
			return new Object [] {
				4,5,6,7
			};
					
	}
	
	@Test(dataProvider = "DataToDelete")
	public void test_delete(int userId) {
		
		 
		baseURI = "http://localhost:3000/";
		
		 
		when().
			put("/users/"+userId).
		then().
			statusCode(200); 
		
	}
	
	
	
}
