package com.warun.SPBootTest.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
  
@RestController
public class HelloWorldController {
//using get method and hello-world URI  
	
	
	@GetMapping(path = "/warun")
	public String helloWorld() {
		int a=1;
		int b=10;
		int c=a+b;

		return "Hello warun";
	}
	
	@GetMapping(path = "/kumar")
	public ResponseEntity<String> helloWorld1() {
		return new ResponseEntity<String>("Hello warun",HttpStatus.ACCEPTED);
	}
	
	@GetMapping(path = "/aa")
	public @ResponseBody ResponseEntity<String> helloWorld2() {
		return new ResponseEntity<String>("Hello AA",HttpStatus.ACCEPTED);
	}
}
