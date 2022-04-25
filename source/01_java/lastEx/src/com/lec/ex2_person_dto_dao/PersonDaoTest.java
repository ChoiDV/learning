package com.lec.ex2_person_dto_dao;

import java.util.ArrayList;
import java.util.Vector;

public class PersonDaoTest {
	public static void main(String[] args) {
		PersonDao dao = PersonDao.getInstance();
		PersonDto dto = new PersonDto("김길순","배우",60,70,80);
		int result = dao.insertPerson(dto);   // 입력 test
		System.out.println(result == PersonDao.SUCCESS ? "입력성공" : "입력실패");
		
		ArrayList<PersonDto> dtos = dao.selectJname("가수");
		if (dtos.size() != 0) {   // if(dtos.isEmpty() 도 가능
			for(PersonDto d : dtos) {
				System.out.println(d);
			}
		} else {
			System.out.println("해당 직업의 사람이 등록되지 않았습니다.");
		}
		
		System.out.println("----------------3번------------------");
		dtos = dao.selectAll();   // 3. 전체조회 test
		if(dtos.size() != 0) {
			for (PersonDto d : dtos) {
				System.out.println(d);
			}
		} else {
			System.out.println("등록된 사람이 없습니다.");
		}
		// 4번
		Vector<String> jnames = dao.jnameList();
		System.out.println(jnames);
		
	}
}
