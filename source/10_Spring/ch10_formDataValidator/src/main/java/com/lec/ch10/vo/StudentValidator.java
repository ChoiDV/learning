package com.lec.ch10.vo;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {   // 검증할 객체의 클래스 타입 명시 	
		return Student.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) { 
		// 컨트롤러에서 호출 :  validate(Student, errors) 호출
		Student student = (Student)target;
		String name = student.getName(); // 검증할 이름 받기
		int id = student.getId();  // 검증할 아이디 받기
//		if(name == null || name.trim().equals("")) {
//			// name 에러 
//			errors.rejectValue("name", "no"); // name 에러 등록
//		}
		// 위의 if문 대신 함수 쓰기
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "no"); // name 에러 등록  근데 이거는 String만 가능
		// rejectIfEmptyOrWhitespace 는 함수자체에서 조건을 넣은것. 
		//  Empty 하거나 "" 이냐? 즉, null || .equals("") 와 같은것
		if(id <= 0) {
			errors.rejectValue("id", "no");  // id 에러 등록
		}
		
	}
	
}
