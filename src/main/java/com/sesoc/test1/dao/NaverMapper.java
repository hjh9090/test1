package com.sesoc.test1.dao;

import com.sesoc.test1.vo.NaverVO;

public interface NaverMapper {

	//네이버에서 가지고 온 값들을 서버에 저장시킴
	public int insertNaver (NaverVO naver);
	
	//서버에 저장 된 회원 정보를 가지고 옴
	public int getNaverMember (String id);
	
	//API로 서버에 저장한 정보를 지움(회원 탈퇴)
	public int deleteNaver (String id);
	
}
