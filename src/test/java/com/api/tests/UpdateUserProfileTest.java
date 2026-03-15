package com.api.tests;

import java.net.Authenticator;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserManagementService;
import com.api.models.request.UserProfileRequest;

import io.restassured.response.Response;

public class UpdateUserProfileTest {
	
	@Test(description="Chexking user update profile flow")
	public void updateUserProfileInfo()
	{
		UserProfileRequest userProfileRequest=new UserProfileRequest.Builder()
				.firstName("Kiara")
				.lastName("Goswami")
				.email("pgpawangoswami88@gmail.com")
				.mobileNumber("9986179142")
				.build();
		UserManagementService userManagementService=new UserManagementService();
		AuthService authService=new AuthService();
		Response res=userManagementService.updateProfile(userProfileRequest, authService.getToken("pawan1234", "pawan1234"));
		System.out.println(res.asPrettyString());
	}

}
