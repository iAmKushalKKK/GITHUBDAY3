package com.Restassured.Testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Restassured.base.RestAPIBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC2_REST_GET extends RestAPIBase {
	
	@BeforeClass
	void getSingleEmployee()
	{
		logger.info("******** Executing Test Case 2_ GET Method ********");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpreq=RestAssured.given();
		response=httpreq.request(Method.GET,"/employee/10661");
	}
	@Test
	void getResponseBody()
	{
		String responseBody=response.getBody().asString();
		logger.info("The Result is:"+responseBody);
		Assert.assertTrue(responseBody!=null);
	
	}

}
