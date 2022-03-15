package com.lec.ex;

public class Quiz2 {

	public static void main(String[] args) {
		
		int[][] arr = { {5,5,5,5,5}, 
						{10,10,10,10,10},
						{20,20,20,20,20},
						{30,30,30,30,30}};
		int sum =0;
		
		for(int i=0; i <arr.length; i++) {   // arr.length = 4를 의미
			for(int j =0; j < arr[0].length; j++) { // arr[0].length = 5를 의미
				sum += arr[i][j];
			}
		}		
		System.out.println(sum);		
	}

}
