import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*; 
import static io.restassured.RestAssured.*;

public class TestPost {
	
	@Test
	public void test_post() {
		
		Map <String, Object> map = new HashMap<String, Object>() ;
		
		map.put("name", "tutku");
		map.put("job", "qa engineer");
		System.out.println(map);
	}

}
