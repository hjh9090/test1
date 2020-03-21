package com.sesoc.test1.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

	
	
	private static final Logger logger = LoggerFactory.getLogger(LogoutController.class);
	
	
	@GetMapping("logout")
	public String logOut (HttpSession httpsession) {
		logger.info("로그아웃 페이지로 이동하였습니다.");
			
		httpsession.invalidate();
//			httpsession.removeAttribute("sessionId");
			
		return "logoutForm";
	}
	
}
