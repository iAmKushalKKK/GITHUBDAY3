package com.Restassured.Testcases;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;

import com.Restassured.base.RestAPIBase;
import com.Restassured.utilities.RestAPIUtil;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC4_REST_PUT extends RestAPIBase {

	String empName=RestAPIUtil.empName();
	String empSal=RestAPIUtil.empSal();
	String empAge=RestAPIUtil.empAge();
	
	@BeforeClass
	void postNewEmployee() throws InterruptedException
	{
		logger.info("****** Executing the Test Case 4_PUT Method *******");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpreq=RestAssured.given();
		
		JSONObject requestParams=new JSONObject();
		requestParams.put("name",empName);
		requestParams.put("salary",empSal);
		requestParams.put("age",empAge);
		
		httpreq.header("Content-Type","application/json");
		httpreq.body(requestParams.toJSONString());
		response=httpreq.request(Method.PUT,"/update/");		
		Thread.sleep(5000);
	}
	
	
}
