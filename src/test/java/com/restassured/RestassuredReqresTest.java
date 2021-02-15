package com.restassured;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.equalTo;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

public class RestassuredReqresTest extends TestBase {

	RequestSpecification httpRequest = null;
	Response response = null;
	//private static final Logger LOGGER = Logger.getLogger(RestassuredReqresTest.class);
	
	@BeforeClass  
	public void SetReqresBase() {  
		 
		RestAssured.baseURI = "https://reqres.in";
		//BasicConfigurator.configure();
		/*LOGGER.getRootLogger().setLevel(Level.INFO);
		BasicConfigurator.configure();*/
	    //System.out.println("This method is executed before Class");
	    logger.info("   ===============================================");
	    logger.info("   RestassuredReqresTest starts here");
	    logger.info("   ===============================================");
	 }  
	
	
	@AfterClass  
	public void endReqresBase() {  		
			
	    logger.info("***********************************************");
	    logger.info("RestassuredReqresTest ends here");
	    logger.info("***********************************************");
	    logger.info("running next testclass");
	    
	 }  

	@Test
	public void GetReqresUsersList() {

		//RestAssured.baseURI = "https://reqres.in";
		
		logger.info("   TestMethod1 - GetReqresUsersList");
		logger.info("   Request Sent - https://reqres.in/api/users?page=2");
	       //LOGGER.debug("DEBUG TEST");
	      // LOGGER.error("ERROR TEST");
		response = RestAssured.given().
				   queryParam("page", "2").
				   when().get("/api/users").
				   then().assertThat().statusCode(200).and().
				   header("Content-Type", "application/json; charset=utf-8").and().
				   header("Content-Encoding", "gzip").and().
				   body("data[0].email", equalTo("michael.lawson@reqres.in")).and().
				   body("data[0].first_name", equalTo("Michael")).and().
				   body("data[0].last_name", equalTo("Lawson")).and().
				   body("data[0].avatar", equalTo("https://reqres.in/img/faces/7-image.jpg")).and().
				   body("data[0].id", equalTo(7)).
				   extract().
				   response();
		
		logger.info("Response Received - "+response.body().asString());
		logger.info("TestMethod1 - Success End");
		logger.info("-----------------------------------------------");
		
		
	}

	@Test
	public void PostReqresUser() {

		logger.info("TestMethod2 - PostReqresUser");
		logger.info("Request Sent - https://reqres.in/api/users");
		
		//RestAssured.baseURI = "https://reqres.in";
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "gmorpheus");
		requestParams.put("job", "gleader");
		logger.info("RequestBody Sent - "+requestParams.toString());

		response = RestAssured.given().
				   header("Content-Type", "application/json; charset=utf-8").and().
				   body(requestParams.toJSONString()).
				   when().post("/api/users").
				   then().assertThat().statusCode(201).and().
				   header("Content-Type", "application/json; charset=utf-8").and().
				   extract().
				   response();
		
		logger.info("Response Received - "+response.body().asString());
		logger.info("TestMethod2 - Success End");		
	
	}

	/*
	 * @Test(description = "Demo Run") public void consoleResult() {
	 * System.out.println("test open weather working one"); response =
	 * RestAssured.given().queryParam("q","tampa").queryParam("appid",
	 * "5f970784a48d8c8e90af04858aa37944").get("/weather");
	 * System.out.println("test open weather working two"); JsonPath js =
	 * response.jsonPath(); String ResponseBody =response.body().asString();
	 * System.out.println("Response Body = " + ResponseBody);
	 * //System.out.println("test working"); //
	 * http://api.openweathermap.org/data/2.5/weather?q=tampa&appid=
	 * 5f970784a48d8c8e90af04858aa37944 //
	 * http://api.openweathermap.org/data/2.5/weather?q=tampa&appid=
	 * 5f970784a48d8c8e90af04858aa37944
	 * //api.openweathermap.org/data/2.5/weather?id=4174757&appid=
	 * 5f970784a48d8c8e90af04858aa37944
	 * //api.openweathermap.org/data/2.5/weather?lat=27.964157&lon=-82.452606&appid=
	 * 5f970784a48d8c8e90af04858aa37944
	 * //api.openweathermap.org/data/2.5/weather?zip=33626,US&appid=
	 * 5f970784a48d8c8e90af04858aa37944
	 * 
	 * //api.openweathermap.org/data/2.5/box/city?bbox=12,32,15,37,10&appid=
	 * 5f970784a48d8c8e90af04858aa37944
	 * //api.openweathermap.org/data/2.5/find?lat=55.5&lon=37.5&cnt=10&appid=
	 * 5f970784a48d8c8e90af04858aa37944
	 * 
	 * 
	 * }/
	 */

}
