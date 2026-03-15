package com.api.filters;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LoggingFilter implements Filter {
	 private static final Logger logger = LogManager.getLogger(LoggingFilter.class);
	@Override
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		logRequest(requestSpec);
		Response res=ctx.next(requestSpec, responseSpec);
		logResponse(res);
		return res;
	}
	
	public void logRequest(FilterableRequestSpecification requestSpec)
	{
		logger.info("BASE_URI:"+requestSpec.getBaseUri());
		logger.info("Request Header:"+requestSpec.getHeaders());
		logger.info("Request Payload:"+requestSpec.getBody());
	}
	
	public void logResponse(Response res)
	{
		logger.info("Status Code:"+res.getStatusCode());
		logger.info("Response Header:"+res.headers());
		logger.info("Response Body:"+res.getBody().prettyPrint());
	}

}
