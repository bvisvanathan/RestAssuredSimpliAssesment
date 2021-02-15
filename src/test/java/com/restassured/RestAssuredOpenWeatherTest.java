package com.restassured;

import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredOpenWeatherTest extends TestBase {

	RequestSpecification httpRequest = null;
	Response response = null;
	
	@BeforeClass  
	public void SetOpenWeatherBase() {  
		 
		RestAssured.baseURI = "http://api.openweathermap.org/data/2.5";
		logger.info("===============================================");
	    logger.info("RestAssuredOpenWeatherTest starts here");
	    logger.info("===============================================");
	    
	 } 
	
	@AfterClass  
	public void endOpenWeatherBase() {  		
			
	    logger.info("***********************************************");
	    logger.info("RestAssuredOpenWeatherTest ends here");
	    logger.info("***********************************************");
	    //logger.info("running next testclass");
	    
	 }  

	@Test
	public void GetOpenWeatherByCityName() {

		//RestAssured.baseURI = "http://api.openweathermap.org/data/2.5";
		logger.info("TestMethod1 - GetOpenWeatherByCityName");
		logger.info("Request Sent - http://api.openweathermap.org/data/2.5?q=tampa&appid=5f970784a48d8c8e90af04858aa37944");

		response = RestAssured.given().
				   queryParam("q", "tampa").
				   queryParam("appid", "5f970784a48d8c8e90af04858aa37944").
				   when().get("/weather").
				   then().assertThat().statusCode(200).and().
				   header("Content-Type", "application/json; charset=utf-8").and().
				   body("name", equalTo("Tampa")).and().
				   body("id", equalTo(4174757)).and().
				   body("sys.country", equalTo("US")).and().
				   extract().
				   response();
		
		logger.info("Response Received - "+response.body().asString());
		logger.info("TestMethod1 - Success End");
		logger.info("-----------------------------------------------");

	}

	@Test
	public void GetOpenWeatherByCityId() {

		//RestAssured.baseURI = "http://api.openweathermap.org/data/2.5";
		logger.info("TestMethod2 - GetOpenWeatherByCityId");
		logger.info("Request Sent - http://api.openweathermap.org/data/2.5/weather?id=4174757&appid=5f970784a48d8c8e90af04858aa37944");

		response = RestAssured.given().
				   queryParam("id", 4174757).
				   queryParam("appid", "5f970784a48d8c8e90af04858aa37944").
				   when().get("/weather").
				   then().assertThat().statusCode(200).and().
				   header("Content-Type", "application/json; charset=utf-8").and().
				   body("name", equalTo("Tampa")).and().
				   body("id", equalTo(4174757)).and().
				   body("sys.country", equalTo("US")).and().
				   extract().
				   response();
		
		logger.info("Response Received - "+response.body().asString());
		logger.info("TestMethod2 - Success End");
		logger.info("-----------------------------------------------");

	}

	@Test
	public void GetOpenWeatherByGeography() {

		//RestAssured.baseURI = "http://api.openweathermap.org/data/2.5";
		logger.info("TestMethod3 - GetOpenWeatherByGeography");
		logger.info("Request Sent - http://api.openweathermap.org/data/2.5/weather?lat=27.964157&lon=-82.452606&appid=5f970784a48d8c8e90af04858aa37944");

		response = RestAssured.given().
				   queryParam("lat", 27.964157).
				   queryParam("lon", -82.452606).
				   queryParam("appid", "5f970784a48d8c8e90af04858aa37944").
				   when().get("/weather").
				   then().assertThat().statusCode(200).and().
				   header("Content-Type", "application/json; charset=utf-8").and().
				   body("name", equalTo("Tampa")).and().
				   body("id", equalTo(4174757)).and().
				   body("sys.country", equalTo("US")).and().
				   extract().
				   response();
		
		logger.info("Response Received - "+response.body().asString());
		logger.info("TestMethod3 - Success End");
		logger.info("-----------------------------------------------");


	}

	@Test
	public void GetOpenWeatherByZip() {

		//RestAssured.baseURI = "http://api.openweathermap.org/data/2.5";
		logger.info("TestMethod4 - GetOpenWeatherByZip");
		logger.info("Request Sent - http://api.openweathermap.org/data/2.5/weather?zip=33626,US&appid=5f970784a48d8c8e90af04858aa37944");

		response = RestAssured.given().
				   queryParam("zip", "33626,US").
				   queryParam("appid", "5f970784a48d8c8e90af04858aa37944").
				   when().get("/weather").
				   then().assertThat().statusCode(200).and().
				   header("Content-Type", "application/json; charset=utf-8").and().
				   body("name", equalTo("Tampa")).and().
				   body("id", equalTo(0)).and().
				   body("sys.country", equalTo("US")).and().
				   extract().
				   response();
		
		logger.info("Response Received - "+response.body().asString());
		logger.info("TestMethod4 - Success End");
		logger.info("-----------------------------------------------");

	}

	@Test
	public void GetOpenWeatherWithinRectangleGeography() {

		//RestAssured.baseURI = "http://api.openweathermap.org/data/2.5";
		logger.info("TestMethod5 - GetOpenWeatherWithinRectangleGeography");
		logger.info("Request Sent - http://api.openweathermap.org/data/2.5/box/city?bbox=12,32,15,37,10&appid=5f970784a48d8c8e90af04858aa37944");

		response = RestAssured.given().
				   queryParam("bbox", "12,32,15,37,10").
				   queryParam("appid", "5f970784a48d8c8e90af04858aa37944").
				   when().get("/box/city").
				   then().assertThat().statusCode(200).and().
				   header("Content-Type", "application/json; charset=utf-8").and().
				   body("cnt", equalTo(15)).and().
				   extract().
				   response();
		
		logger.info("Response Received - "+response.body().asString());
		logger.info("TestMethod5 - Success End");
		logger.info("-----------------------------------------------");

	}

	@Test
	public void GetOpenWeatherWithinCircularGeography() {

		//RestAssured.baseURI = "http://api.openweathermap.org/data/2.5";
		logger.info("TestMethod6 - GetOpenWeatherWithinCircularGeography");
		logger.info("Request Sent - http://api.openweathermap.org/data/2.5/find?lat=55.5&lon=37.5&cnt=10&appid=5f970784a48d8c8e90af04858aa37944");

		response = RestAssured.given().
				   queryParam("lat", 55.5).
				   queryParam("lon", 37.5).
				   queryParam("cnt", 10).
				   queryParam("appid", "5f970784a48d8c8e90af04858aa37944").
				   when().get("/find").
				   then().assertThat().statusCode(200).and().
				   header("Content-Type", "application/json; charset=utf-8").and().
				   body("count", equalTo(10)).and().
				   extract().
				   response();
		
		logger.info("Response Received - "+response.body().asString());
		logger.info("TestMethod6 - Success End");
		logger.info("-----------------------------------------------");

	}

}
