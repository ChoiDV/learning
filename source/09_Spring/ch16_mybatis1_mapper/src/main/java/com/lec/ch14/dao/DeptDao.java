package com.lec.ch14.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lec.ch14.dto.Dept;

@Mapper
public interface DeptDao {
	// 리턴타입 Dept List 
	public List<Dept> deptList();  // 템플릿의 리턴타입이 List라서 메소드 타입도 리스트로 정해져있는거라서 따라야함
}
