package com.sesoc.test1.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sesoc.test1.vo.NaverVO;

@Repository
public class NaverDAO {

	@Autowired
	private SqlSession session;
	
	/*
	 * 네이버에서 가지고 온 값들을 서버에 저장시키는 SQL
	*/
	public int insertNaver (NaverVO naver) {
		NaverMapper mapper = session.getMapper(NaverMapper.class);
			int result = 0;
		try {
			result = mapper.insertNaver(naver);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/*
	 * 서버에 저장된 계정 정보를 불러와 sessionScope영역으로 저장하는 SQL
	 */
	public int getNaverMember (String id) {
		NaverMapper mapper = session.getMapper(NaverMapper.class);
		int result = 0;
		
		try {
			result = mapper.getNaverMember(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/*
	 * 서버에 저장 된 계정 정보를 지우는 SQL
	 * */
	public int deleteNaver (String id) {
		NaverMapper mapper = session.getMapper(NaverMapper.class);
		int result = 0;
		
		try {
			result = mapper.deleteNaver(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
}
