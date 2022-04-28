package com.lec.ex3_student;

import java.util.ArrayList;

public class TestMain {
	public static void main(String[] args) {
		StudentDao dao = StudentDao.getInstance();
		System.out.println("1.�й��˻�");
		StudentDto dto = dao.selectSno(2022001);
		System.out.println(dto);
		System.out.println("2.�̸��˻�");
		ArrayList<StudentDto> students = dao.selectSname("������");
		System.out.println(students);
		System.out.println("3.�����˻�");
		ArrayList<StudentDto> students2 = dao.selectMname("��ǻ�Ͱ���");
		System.out.println(students2);

		System.out.println("4.�л��Է�");
		StudentDto insertdto = new StudentDto("������", "��ǻ�Ͱ���", 100);
		int result = dao.insertStudent(insertdto);
		System.out.println(result == StudentDao.SUCCESS ? "�Է¼���" : "�Է½���");

		System.out.println("5.�л�����");
		StudentDto updatedto = new StudentDto(2022009, "������", "��ǻ�Ͱ���", 100);
		int result2 = dao.updateStudent(updatedto);
		System.out.println(result2 == StudentDao.SUCCESS ? "��������" : "��������");

		System.out.println("6.�л�  ���");
		ArrayList<StudentDto> selectstd = dao.selectStudent();
		for (StudentDto sdo : selectstd) {
			System.out.println(sdo);
		}

		System.out.println("7.������ ���");
		ArrayList<StudentDto> selectexple = dao.selectSexple();
		if (selectexple.isEmpty()) {
			System.out.println("������ ����");
		} else {
			for (StudentDto sdo : selectexple) {
				System.out.println(sdo);
			}
		}
		
		System.out.println("8.����ó�� ");
		int exple = 2022004;
		int result3 = dao.updateSexple(exple);
		System.out.println(result3 == StudentDao.SUCCESS ? "��������" : "��������");

	}

}
