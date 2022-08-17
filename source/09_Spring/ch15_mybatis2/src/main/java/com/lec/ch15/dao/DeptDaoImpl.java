package com.lec.ch15.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lec.ch15.model.Dept;

@Repository  // 빈생성, 스프링 컨테이너에게 DAO임을 알려주는 어노테이션(빈생성)
public class DeptDaoImpl implements DeptDao {
	@Autowired
	private SqlSession sessionTemplate;  // root-context.xml에서 만든 SqlSessionTemplate 객체의 상위 타입 : SqlSession 
										 // 즉, SqlSessionTemplate를 가져온다 라고 생각하면 된다.
	@Override
	public List<Dept> deptList() {
		return sessionTemplate.selectList("deptList");
	}

}
