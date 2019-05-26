package com.Restassured.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestAPIUtil {
	
	public static String empName()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(2);
		
		return("EMP-"+generatedString);
	}
	public static String empSal()
	{
		String generatedString=RandomStringUtils.randomNumeric(5);
		
		return(generatedString);
	}
	public static String empAge()
	{
		String generatedString=RandomStringUtils.randomNumeric(2);
				
		return(generatedString);
	}

}
