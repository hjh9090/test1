package com.sesoc.test1.dao;

import com.sesoc.test1.vo.NaverVO;

public interface NaverMapper {

	//네이버에서 가지고 온 값들을 서버에 저장시킴
	public int insertNaver (NaverVO naver);
	
}
