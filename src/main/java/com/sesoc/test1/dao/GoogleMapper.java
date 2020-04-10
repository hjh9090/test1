package com.sesoc.test1.dao;

import com.sesoc.test1.vo.GoogleVO;

public interface GoogleMapper {
	
	//가입
	public int insertGoogle (GoogleVO google);
	
	//로그인
	public int getGoogle(String id);
	
	//탈퇴
	public int deleteGoogle(String id);
}
