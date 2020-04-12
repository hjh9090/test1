package com.sesoc.test1.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sesoc.test1.vo.GoogleVO;

@Repository
public class GoogleDAO {

	
	@Autowired
	private SqlSession session;
	
	/*
	 * result에서 -1 이 나오면 DB쪽 접근이 안되었기 때문
	 * 0이 나오면 DB는 들어 갔지만 다른 부분에서 에러가 나옴
	 * */
	public int insertGoogle (GoogleVO google) {
		int result = -1;
		
		try {
		
		GoogleMapper mapper = session.getMapper(GoogleMapper.class);
		
		result = mapper.insertGoogle(google);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int getGoogle (String id) {
	int result = -1;
	try {
		
		GoogleMapper mapper = session.getMapper(GoogleMapper.class);
		
		result = mapper.getGoogle(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteGoogle (String id) {
		int result = -1;
		
		try
		{
			GoogleMapper mapper = session.getMapper(GoogleMapper.class);
			result = mapper.deleteGoogle(id);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}

		return result;
	}
	
	
}
