package com.api.base;

import static io.restassured.RestAssured.*;

import com.api.filters.LoggingFilter;
import com.api.models.request.LoginRequest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
	
	private static final String BASE_URL="http://64.227.160.186:8080/";
	private RequestSpecification reqSpecification;
	
	static
	{
		RestAssured.filters(new LoggingFilter());
	}
	public BaseService()
	{
		reqSpecification=given().baseUri(BASE_URL);
	}
	
	protected Response postRequest(Object payload,String endpoint)
	{
		return reqSpecification
		        .contentType(ContentType.JSON)
		        .body(payload)
		        .log().all()
		        .post(endpoint);
	}
	protected Response getRequest(String endpoint)
	{
		return reqSpecification		      
		        .log().all()
		        .get(endpoint);

}

	protected void setAuth(String token)
	{
		reqSpecification.headers("Authorization","Bearer "+token);
	}

	protected Response putRequest(Object payload,String endpoint)
	{
		return reqSpecification
		        .contentType(ContentType.JSON)
		        .body(payload)
		        .log().all()
		        .put(endpoint);
	}
}
