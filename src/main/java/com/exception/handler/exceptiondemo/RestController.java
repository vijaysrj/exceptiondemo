package com.exception.handler.exceptiondemo;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@PostMapping(value = "/buy")
	@CrossOrigin
	public Map<String, Object> buy(@RequestBody Map<String, Object> request) throws Exception {

		
		if(LocalDateTime.now().getHour() > 13 && LocalDateTime.now().getHour() < 15) {
			
			throw new Exception("Shop is closed for lunch");
		}
		
		return request;
	}

}
