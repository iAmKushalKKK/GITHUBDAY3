package com.Restassured.Testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Restassured.base.RestAPIBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC1_REST_GET extends RestAPIBase {

	@BeforeClass
	void getAllEmployees()
	{
		logger.info("********* Executing Case 1_GET Method ********");
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpreq=RestAssured.given();
		response=httpreq.request(Method.GET,"/employees");
	}
	@Test
	void checkResponseBody()
	{
		String responseBody=response.getBody().asString();
		logger.info("The Result is:"+responseBody);
		System.out.println(responseBody);
		Assert.assertTrue(responseBody!=null);		
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
		//Assert.assertFalse(responsetime>2000,"The Response is greaterthan 2000");
	}
	@Test(priority=4)
	void getStatusLine()
	{
		logger.info("******* Getting the Status Line******");
		
		String statusLine=response.getStatusLine();
		logger.info("Satus line is:"+statusLine);
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
	/*@Test(priority=8)
	void getContentLength()
	{
		String contentLength=response.getHeader("Content-Length");
		logger.info("The Content Length is:"+contentLength);
		Assert.assertTrue(contentLength<20);
	}
	*/
}
