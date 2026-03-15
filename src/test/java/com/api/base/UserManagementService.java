package com.api.base;

import com.api.models.request.LoginRequest;
import com.api.models.request.UserProfileRequest;

import io.restassured.response.Response;

public class UserManagementService extends BaseService {
private static final String BASE_PATH="api/users/";

public Response getProfile(String token)
{
	setAuth(token);
	return getRequest(BASE_PATH +"profile");
}

public Response updateProfile(UserProfileRequest payload,String token)
{
	setAuth(token);
	return putRequest(payload,BASE_PATH +"profile");
}

}
