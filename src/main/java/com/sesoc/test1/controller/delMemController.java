package com.sesoc.test1.controller;


import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.sesoc.test1.dao.GoogleDAO;
import com.sesoc.test1.dao.NaverDAO;
import com.sesoc.test1.vo.GoogleVO;

@Controller
public class delMemController {

	private static final Logger logger = LoggerFactory.getLogger(delMemController.class);
	
	@Autowired
	private NaverDAO dao;
	private GoogleDAO dao2;
	
	@GetMapping("deletemember")
	public String deleteMember () {
		logger.info("회원 탈퇴 페이지로 이동하였습니다.");
		return "deletemember";
	}
	
	@GetMapping("delete")
	@ResponseBody
	public String delete (HttpSession httpsession, GoogleVO google) {
		String clientId = "z_lyTyQUbIC8kv8VfFwH";
		String clientSecret = "EdlvjsCOLs";
		String accessToken = (String)httpsession.getAttribute("access_token");
		String apiURL;
		apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=delete&";
		apiURL += "client_id=" + clientId;
		apiURL += "&client_secret=" + clientSecret;
		apiURL += "&access_token=" + accessToken;
		apiURL += "&service_provider=NAVER";
		
		dao.deleteNaver((String)httpsession.getAttribute("sessionId"));
		httpsession.removeAttribute("sessionId");
		
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(apiURL, String.class);
		System.out.println(result);
		
		
		return "";
	}
	
//	@GetMapping
//	public String googleDelete (String id) {
//		logger.info("구글 회원 탈퇴로 이동");
//		return ""
//	}
//	

}
