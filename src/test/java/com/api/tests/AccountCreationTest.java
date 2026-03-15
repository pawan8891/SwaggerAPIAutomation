package com.api.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignupRequeest;

import io.restassured.response.Response;

public class AccountCreationTest {
	
	@Test(description="Verify if sign up request is working")
	public void createAccountTest()
	{
		SignupRequeest signupRequeest=new SignupRequeest.Builder().Username("Test12388911")
		.Email("Test2388911t@yahoo.com")
		.FirstName("Test")
		.LastName("Testing")
		.Password("Test1238")
		.MobileNumber("9876543210")
		.build();
		
		AuthService authService=new AuthService();
		Response res=authService.signup(signupRequeest);
		System.out.println(res.asPrettyString());
		Assert.assertEquals(res.asPrettyString(), "User registered successfully!");
		
	}
}
