package com.sesoc.test1.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sesoc.test1.dao.NaverDAO;
import com.sesoc.test1.vo.NaverVO;


@Controller
//@RestController
public class naverLoginAPI {

	
	@Autowired
	private NaverDAO dao;
	
	@Autowired
     private RestTemplate restTemplate;
	
	
	private static final Logger logger = LoggerFactory.getLogger(naverLoginAPI.class);
	
	@GetMapping("naverlogin")
	public String naverlogin() {
		
		//token값은 1시간마다 (3600ms) 새로 갱신 된다
		logger.info("로그인으로 이동하였습니다.");
		return "naverlogin";
	}
	
	@GetMapping("/callback")
	public String callback (HttpSession httpsession) {
		logger.info("콜백 하였습니다.");
		
		return "callback";
	}
	
	@GetMapping("viewForm")
	@ResponseBody
	public String viewForm (String access_token, NaverVO naver, HttpSession httpsession)throws Exception {		
        String header = "Bearer " + access_token; // Bearer 다음에 공백 추가
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json; charset=UTF-8");
        headers.set("Authorization", header);
        HttpEntity entity = new HttpEntity(headers);
        Map<String, Object> result = restTemplate.exchange("https://openapi.naver.com/v1/nid/me", HttpMethod.GET, entity, Map.class).getBody();
        Map<String, String> naverInfo = (LinkedHashMap<String, String>) result.get("response");
        
        String id = naverInfo.get("id");
        String email = naverInfo.get("email");
        String gender = naverInfo.get("gender");
        String birthday = naverInfo.get("birthday");
        String nickname = naverInfo.get("nickname");
        String profile_image = naverInfo.get("profile_image");
        String age = naverInfo.get("age");
        
        logger.debug(id);
        logger.debug(email);
        logger.debug(gender);
        logger.debug(birthday);
        logger.debug(nickname);
        logger.debug(profile_image);
        logger.debug(age);
        //네이버의 회원정보는 String으로 가지고 오게 됩니다.
            naver.setId(id);
            naver.setEmail(email);
            naver.setGender(gender);
            naver.setBirthday(birthday);
            naver.setNickname(nickname);
            naver.setProfile_image(profile_image);
            naver.setAge(age);
            
            httpsession.setAttribute("sessionId", id);
            httpsession.setAttribute("sessionNickname", nickname);
            
            dao.insertNaver(naver);
        
        return "";
        
    }

	
}
