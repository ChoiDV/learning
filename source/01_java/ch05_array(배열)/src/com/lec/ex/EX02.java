package com.lec.ex;

public class EX02 {

	public static void main(String[] args) {
		// 배열을 출력할때는 일반 for문보다 확장 for문을 사용한다.
		// 일반 for문 vs 확장 for문 ( 배열 출력할때만 사용한다.)

		int[] arr = new int[3]; // int[] arr = {0,0,0}; 과 같다
		for (int idx = 0; idx < arr.length; idx++) {
			System.out.printf("arr[%d] = %d\n", idx, arr[idx]);
		}
		for (int temp: arr) { 	// for( 임시변수 : 배열변수 ){ 출력할것 };
			System.out.println(temp);   // 확장 for문은 인덱스 번호는 모름 인덱스번호가 필요할때는 일반 for문 사용
		}
		
		for(int i =0; i< arr.length ; i++) {  // 일반 for문을 이용한 배열 수정 가능.
			arr[i] = 5;
			System.out.println(arr[i]);
		}
		
		for (int temp : arr) {  // 확장 for문을 이용한 배열 수정. 근데 불가능함.
								// 확장for문을 이용한 배열 수정은 
			temp = 9;			// temp 라는 임시변수를 거치기때문에 정작 arr 배열에는 값이 수정이 안되고 
								// temp를 수정하는것이 됨.
		}
		
	
	}
	
}
