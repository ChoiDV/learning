package com.lec.ex2_person_dto_dao;

import java.util.ArrayList;
import java.util.Vector;

public class PersonDaoTest {
	public static void main(String[] args) {
		PersonDao dao = PersonDao.getInstance();
		PersonDto dto = new PersonDto("����","���",60,70,80);
		int result = dao.insertPerson(dto);   // �Է� test
		System.out.println(result == PersonDao.SUCCESS ? "�Է¼���" : "�Է½���");
		
		ArrayList<PersonDto> dtos = dao.selectJname("����");
		if (dtos.size() != 0) {   // if(dtos.isEmpty() �� ����
			for(PersonDto d : dtos) {
				System.out.println(d);
			}
		} else {
			System.out.println("�ش� ������ ����� ��ϵ��� �ʾҽ��ϴ�.");
		}
		
		System.out.println("----------------3��------------------");
		dtos = dao.selectAll();   // 3. ��ü��ȸ test
		if(dtos.size() != 0) {
			for (PersonDto d : dtos) {
				System.out.println(d);
			}
		} else {
			System.out.println("��ϵ� ����� �����ϴ�.");
		}
		// 4��
		Vector<String> jnames = dao.jnameList();
		System.out.println(jnames);
		
	}
}
