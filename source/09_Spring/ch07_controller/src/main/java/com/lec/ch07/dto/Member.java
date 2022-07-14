package com.lec.ch07.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	private String id;
	private String pw;
	
	@Override   
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + "]";
	}  // lombok 의 toString이 마음에 안들면 이렇게 오버라이드하면 된다.
	
	
}
