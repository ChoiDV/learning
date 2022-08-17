package com.lec.ch15.dao;

import java.util.List;

import com.lec.ch15.model.Dept;

public interface DeptDao {
	// 파라미터가 없으면 매개변수 넣지 않아도됌.
	public List<Dept> deptList(); 
}
