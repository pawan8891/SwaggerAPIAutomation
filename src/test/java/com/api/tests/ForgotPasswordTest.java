package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;

import io.restassured.response.Response;

public class ForgotPasswordTest {
	
	@Test(description="Verify forgot password flow...")
	public void forgotPassword()
	{
		AuthService authService=new AuthService();
		Response res=authService.forgotPassword("test9191@gmail.com");
		System.out.println(res.asPrettyString());
		String str=res.asPrettyString();
		Assert.assertTrue(str.contains("If your email exists in our system, you will receive reset instructions."));
	}

}
