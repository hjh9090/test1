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
		//네이버, 구글로그아웃을 구현 할 경우 해당 토큰값이 만료가 되어 폐기 처리가 됩니다.
		//폐기 되지 않게 하기 위해 httpsession에서만 값을 사라지게 만들겠습니다.
		httpsession.invalidate();
		
		return "logoutForm";
	}
	
}
