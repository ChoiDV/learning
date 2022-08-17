package com.lec.ex;

public class Ex01 {

	public static void main(String[] args) {
		// 배열   - 레퍼런스 변수 = 값을 갖고있는게 아닌 주소값을 가지고있는 변수들을 레퍼런스 변수라고 함.
		int i = 10; // 변수의 선언과 초기화
		i = 20;
		//  1. 배열 변수의 선언과 초기화
		int[] iArr = {10,20,30,40,50};
		iArr[2] = 300;  // 배열을 index로 접근 0번부터 시작 0,1,2,3,4,5 ...  
		//배열의 방의 개수를  .length 로 나타냄   iArr.length
		
		for(int idx = 0; idx < iArr.length; idx++) {
			System.out.println(iArr[idx]);
		}
		
		// 2. 배열 변수 선언과 배열 메모리 공간 확보 = 한번 지정된 배열의 크기는 변경 불가.
		int[] iArr2 = new int[5];
		for(int idx =0; idx<iArr2.length; idx++) {
			System.out.printf("iArr2[%d] = %d\n", idx, iArr2[idx]);
		}
		iArr2[0] = 999; 
		iArr2[1] = 888;
		for(int idx =0; idx<iArr2.length; idx++) {
			System.out.printf("iArr2[%d] = %d\n", idx, iArr2[idx]);
		}
		
		// 3. 배열 변수만 먼저 선언
		int[] iArr3;
		iArr3 = new int[3];   // 배열 공간 확보하고 그 안의 값은 0으로 자동 초기화 (레퍼런스 변수)
		for(int idx=0; idx<iArr3.length; idx ++) {
			System.out.printf("iArr3[%d] = %d\n", idx, iArr3[idx]);
		}
	
		
	}

}
