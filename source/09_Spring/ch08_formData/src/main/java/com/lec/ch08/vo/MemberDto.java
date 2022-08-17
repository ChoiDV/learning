package com.lec.ch08.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {
	private String name;
	private String id;
	private String pw;
	private int age;
	private String email;
	private String address;
	// Bean 사용하려면 input에서의 name과 dto의 필드이름과 동일하게
	
	// 폼 데이터 사용을 위해 : getter & 매개변수 없는 생성자
	
}
