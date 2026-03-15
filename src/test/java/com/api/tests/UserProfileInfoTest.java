package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserManagementService;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class UserProfileInfoTest {
	
	@Test(description="Checking user profile info...")
	public void getUserProfileInfo()
	{
		AuthService authService=new AuthService();
		UserManagementService userManagementService=new UserManagementService();
		Response res=userManagementService.getProfile(authService.getToken("pawan1234", "pawan1234"));
		System.out.println(res.asPrettyString());
		
		UserProfileResponse userProfileRes=res.as(UserProfileResponse.class);
		System.out.println(userProfileRes.getEmail());
		
		
		
	}

}
