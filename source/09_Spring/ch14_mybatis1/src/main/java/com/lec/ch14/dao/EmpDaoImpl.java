package com.lec.ch14.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lec.ch14.dto.Emp;

@Repository
public class EmpDaoImpl implements EmpDao {
	@Autowired
	private SqlSession sessionTemplate;  // id가 뭐인것을 가져오는 쿼리를 수행할 아이 
	
	@Override
	public List<Emp> empList(Emp schEmp) {	
		return sessionTemplate.selectList("empList",schEmp);
	}

}
