package com.sesoc.test1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class naverLoginAPI {

	
	
	@GetMapping("naverlogin")
	public String naverlogin() {
		
		return "naverlogin";
	}
	
	
}
