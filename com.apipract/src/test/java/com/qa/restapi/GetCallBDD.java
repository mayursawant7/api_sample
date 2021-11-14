package com.qa.restapi;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class GetCallBDD {
	
	@Test
	//public void verifyGetMethod() {
		
	/*given().
	when().
	get("http://ergast.com/api/f1/2017/circuits.json").
	then().
	assertThat().
	body("MRData.CircuitTable.Circuits.circuitId",hasSize(20));*/
		
		public void test_addNewVideoGame(){
			HashMap data = new HashMap();
			data.put("circuitId","albert_park");
			data.put("url","http:\\/\\/en.wikipedia.org\\/wiki\\/Melbourne_Grand_Prix_Circuit");
			data.put("circuitName","Albert Park Grand Prix Circuit");
			data.put("Location","");
		

			Response res=
			(Response) given()
				.contentType("application/json")
				.body(data)  //...........................passing data
			.when()	

				.get("http://ergast.com/api/f1/2017/circuits.json") // ....passing req URL
			.then()
				.statusCode(200)     // .........Expected Code
				.log().body()      // ............Expected o/p body in console
				.extract().response();   //.........Copy response and store in res

			String jsonString=res.asString();
			Assert.assertEquals(jsonString.contains("Record Added Successfully"),true);
			}


			/*//Varify response for single game
			@Test
			public void test_getVideoGame(){
			given()
			.when()
				.get("http://localhost:8080/app/videogames/100")
			.then()
				.statusCode(200)
				.log().body() 
				.body("videoGame.id",equalTo("100")) 
				.body("videoGame.id", equalTo("Spider-Man"));
			}*/
		
		
	

}
