package com.Restassured.Testcases;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.Restassured.base.RestAPIBase;
import com.Restassured.utilities.RestAPIUtil;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

public class TC3_REST_POST extends RestAPIBase {
	
	String empName=RestAPIUtil.empName();
	String empSal=RestAPIUtil.empSal();
	String empAge=RestAPIUtil.empAge();
	
	@BeforeClass
	void postNewEmployee() throws InterruptedException
	{
		logger.info("****** Executing the Test Case 3_POST Method *******");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpreq=RestAssured.given();
		
		JSONObject requestParams=new JSONObject();
		requestParams.put("name",empName);
		requestParams.put("salary",empSal);
		requestParams.put("age",empAge);
		
		httpreq.header("Content-Type","application/json");
		httpreq.body(requestParams.toJSONString());
		response=httpreq.request(Method.POST,"/create");		
		System.out.println("Employee Name Generated: "+empName);
		System.out.println("Employee Salary Generated: "+empSal);
		System.out.println("Employee Age Generated: "+empAge);
		Thread.sleep(5000);
	}
	@Test
	public void getResponseBody() throws InterruptedException
	{
		String ResponseBody=response.getBody().asString();
		logger.info("The Results are:"+ResponseBody);
		Assert.assertEquals(ResponseBody.contains(empName),true);
		Assert.assertEquals(ResponseBody.contains(empSal),true);
		Assert.assertEquals(ResponseBody.contains(empAge),true);
	}
	@Test
	public static void getid() throws InterruptedException
	{
		JsonPath jsonPathEvaluator=response.jsonPath();
		String employeeID=jsonPathEvaluator.getString("id");
		System.out.println("Employee ID Generated from Response: "+employeeID);
		Thread.sleep(3000);
	}
	@Test(priority=2)
	void getStatusCode()
	{
		int statuscode=response.getStatusCode();
		logger.info("The Status Code is:"+statuscode);
		Assert.assertEquals(statuscode,200);
	}
	@Test(priority=3)
	void getResponseTime()
	{
		long responsetime=response.getTime();
		logger.info("The Response Time is:"+responsetime);
		Assert.assertTrue(responsetime<10000);
	}
	@Test(priority=4)
	void getStatusLine()
	{
			
		String statusLine=response.getStatusLine();
		logger.info("Status line is:"+statusLine);
		Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
	}
	@Test(priority=5)
	void getContentType()
	{
		String contentType=response.getContentType();
		logger.info("The Content Type is:"+contentType);
		Assert.assertEquals(contentType,"text/html; charset=UTF-8");
	}
	@Test(priority=6)
	void getServerType()
	{
		String serverType=response.getHeader("Server");
		logger.info("The Server Type is:"+serverType);
		Assert.assertEquals(serverType,"nginx/1.14.1");
	}
	@Test(priority=7)
	void getContentEncode()
	{
		String contentEncode=response.getHeader("Content-Encoding");
		logger.info("The Content Encoding is:"+contentEncode);
		Assert.assertEquals(contentEncode,"gzip");
	}
	@AfterClass
	void exitCode()
	{
		logger.info("***** The Test Case 3 is Successfully Executed*******");
	}
}
