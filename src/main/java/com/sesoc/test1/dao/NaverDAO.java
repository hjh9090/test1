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
	
	/*
	 * result에서 -1 이 나오면 DB쪽 접근이 안되었기 때문
	 * 0이 나오면 DB는 들어 갔지만 다른 부분에서 에러가 나옴
	 * */
	
	public int insertNaver (NaverVO naver) {
		int result = -1;
		try {
			NaverMapper mapper = session.getMapper(NaverMapper.class);
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
		int result = -1;
		
		try {
			NaverMapper mapper = session.getMapper(NaverMapper.class);
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
		int result = -1;
		try {
			NaverMapper mapper = session.getMapper(NaverMapper.class);
			result = mapper.deleteNaver(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
}
