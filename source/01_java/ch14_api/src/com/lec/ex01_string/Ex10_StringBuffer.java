package com.lec.ex01_string;

public class Ex10_StringBuffer {
	public static void main(String[] args) {
		
		// 메모리적으로 손해 
		// 살짝만 수정해도 아예 삭제후 새로 만들기때문에
		String str = "abc";
		System.out.println(str.hashCode());
		str = str+"d";	
		System.out.println(str.hashCode());
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~\n");
				
		StringBuilder strBuilder = new StringBuilder("abc");
		System.out.println("strBuilder 해쉬코드 결과 : " + strBuilder.hashCode());
		System.out.println("strBuilder : "+ strBuilder);
		
		strBuilder.append("def");  // 기존의 "abc"에 "def"를 추가 : abcdef
		System.out.println("append 후 strBuilder : " + strBuilder);  
		System.out.println("추가 후 해쉬코드 결과 : " + strBuilder.hashCode());
		
		strBuilder.insert(3, "AAA"); // 3번째에 "AAA" 추가   :  abcAAAdef
		System.out.println("inter 후 strBuilder : "+strBuilder);
		System.out.println("추가 후 해쉬코드 결과 : " + strBuilder.hashCode());
		// 변경을 계속 해도 해쉬코드값이 변하지 않음
		strBuilder.delete(3, 5);  // 3번째 부터 5번째 앞까지 삭제 : abcAdef
		System.out.println("strBuilder : "+ strBuilder);
		System.out.println("삭제 후 해쉬코드 결과 : " + strBuilder.hashCode());
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		strBuilder.deleteCharAt(3);  // 3번째 문자만 삭제 delete(3,4) 와 같음
		System.out.println("strBuilder : "+ strBuilder);
		System.out.println("삭제 후 해쉬코드 결과 : " + strBuilder.hashCode());
	}
	
}
