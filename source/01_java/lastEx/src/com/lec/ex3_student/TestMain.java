package com.lec.ex3_student;

import java.util.ArrayList;

public class TestMain {
	public static void main(String[] args) {
		StudentDao dao = StudentDao.getInstance();
		System.out.println("1.학번검색");
		StudentDto dto = dao.selectSno(2022001);
		System.out.println(dto);
		System.out.println("2.이름검색");
		ArrayList<StudentDto> students = dao.selectSname("최진영");
		System.out.println(students);
		System.out.println("3.전공검색");
		ArrayList<StudentDto> students2 = dao.selectMname("컴퓨터공학");
		System.out.println(students2);

		System.out.println("4.학생입력");
		StudentDto insertdto = new StudentDto("최진영", "컴퓨터공학", 100);
		int result = dao.insertStudent(insertdto);
		System.out.println(result == StudentDao.SUCCESS ? "입력성공" : "입력실패");

		System.out.println("5.학생수정");
		StudentDto updatedto = new StudentDto(2022009, "오동준", "컴퓨터공학", 100);
		int result2 = dao.updateStudent(updatedto);
		System.out.println(result2 == StudentDao.SUCCESS ? "수정성공" : "수정실패");

		System.out.println("6.학생  출력");
		ArrayList<StudentDto> selectstd = dao.selectStudent();
		for (StudentDto sdo : selectstd) {
			System.out.println(sdo);
		}

		System.out.println("7.제적자 출력");
		ArrayList<StudentDto> selectexple = dao.selectSexple();
		if (selectexple.isEmpty()) {
			System.out.println("제적자 없음");
		} else {
			for (StudentDto sdo : selectexple) {
				System.out.println(sdo);
			}
		}
		
		System.out.println("8.제적처리 ");
		int exple = 2022004;
		int result3 = dao.updateSexple(exple);
		System.out.println(result3 == StudentDao.SUCCESS ? "제적성공" : "제적실패");

	}

}
