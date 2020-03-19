package com.sesoc.test1.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sesoc.test1.vo.NaverVO;

@Repository
public class NaverDAO {

	@Autowired
	private SqlSession session;
	
	
	//네이버에서 가지고 온 값들을 서버에 저장시킴
	public int insertNaver (NaverVO naver) {
		NaverMapper mapper = session.getMapper(NaverMapper.class);
			int result = 0;
		try {
			result = mapper.insertNaver(naver);
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		return result;
	}
	
	
	
	
}
