package com.api.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

@Listeners(com.api.listeners.TestListener.class)
public class LoginAPITest {
	
	@Test(description="Verify login api is working...")
	public void loginTest()
	{
		LoginRequest loginReq=new LoginRequest("pawan1234", "pawan1234");
		AuthService authService=new AuthService();
		Response res=authService.login(loginReq);
		LoginResponse loginResponse=res.as(LoginResponse.class);
		System.out.println("Token is :"+loginResponse.getToken());
		System.out.println("UserName is :"+loginResponse.getUsername());
		System.out.println("Roles are :"+loginResponse.getRoles());
		System.out.println("Id is :"+loginResponse.getId());
		System.out.println("Type is :"+loginResponse.getType());

		
	}
}