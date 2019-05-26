package com.Authentic;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Authentication {

	@Test
	public void preauth()
	{
		RestAssured.baseURI="http://restapi.demoqa.com";
		RequestSpecification httpreq =RestAssured.given();
		httpreq.auth().preemptive().basic("ToolsQA","TestPassword");
		Response res=httpreq.request(Method.GET,"/authentication/CheckForAuthentication");
		int status=res.getStatusCode();
		String statusMsg=res.getBody().asString();
		System.out.println("The Status Code are: "+status);
		System.out.println("The Status Code are: "+statusMsg);
	}
	
}
