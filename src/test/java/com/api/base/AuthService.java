package com.api.base;

import java.util.HashMap;

import com.api.models.request.LoginRequest;
import com.api.models.request.SignupRequeest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

public class AuthService extends BaseService{
	
	private static final String BASE_PATH="api/auth/";
	
	public Response login(LoginRequest payLoad)
	{
		return postRequest(payLoad, BASE_PATH +"login");
	}
	
	public Response signup(SignupRequeest payload)
	{
		return postRequest(payload, BASE_PATH +"signup");
	}
	
	public Response forgotPassword(String payload)
	{
		HashMap<String,String> hm=new HashMap<String, String>();
		hm.put("email", payload);	
		return postRequest(hm, BASE_PATH +"forgot-password");
	}
	
	public String getToken(String username,String password)
	{
		LoginRequest loginReq=new LoginRequest(username, password);
		AuthService authService=new AuthService();
		Response res=authService.login(loginReq);
		LoginResponse loginResponse=res.as(LoginResponse.class);
		return loginResponse.getToken();
	}
}
