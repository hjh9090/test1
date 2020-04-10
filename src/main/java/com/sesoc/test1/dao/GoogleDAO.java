package com.sesoc.test1.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sesoc.test1.vo.GoogleVO;

@Repository
public class GoogleDAO {

	
	@Autowired
	private SqlSession session;
	
	
	public int insertGoogle (GoogleVO google) {
		GoogleMapper mapper = session.getMapper(GoogleMapper.class);
		int result = 0;
		result = mapper.insertGoogle(google);
		return result;
	}
	
	public int getGoogle (String id) {
		GoogleMapper mapper = session.getMapper(GoogleMapper.class);
		int result = 0;
		result = mapper.getGoogle(id);
		return result;
	}
	
	public int deleteGoogle (String id) {
		GoogleMapper mapper = session.getMapper(GoogleMapper.class);
		int result = 0;
		
		try {
			result = mapper.deleteGoogle(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
}
