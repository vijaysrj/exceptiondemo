package com.exception.handler.exceptiondemo;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

@ControllerAdvice
public class CustomExceptionHandler {

	Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);
	
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Map<String,String> handleException(Exception e, HttpServletRequest request){
		
		
		Map<String, Object> requestMap = null;
		try {
			requestMap = new ObjectMapper().readValue(request.getInputStream(), Map.class);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		logger.error("Exception occured for the request:"+requestMap);
		logger.error("Exception is "+e.getMessage());
		
		Map<String,String> response = new HashMap();
		
		response.put("status", "failure");
		
		return response;
		
	}
}
