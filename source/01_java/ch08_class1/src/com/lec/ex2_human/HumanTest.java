package com.lec.ex2_human;

public class HumanTest {
// int age 나이, int height 키, double weight 몸무게, String phoneNum 핸드폰 번호
	public static void main(String[] args) {
		Man moon = new Man();
		Man kim = new Man(22,165,60.5);
		Man choi = new Man(24,179,77.7,"010-4434-9878");
		
		System.out.print(choi.getAge()+ " 살\t ");
		System.out.println(choi.getHeight()+ " cm ");
		System.out.print(choi.getWeight()+ " kg \t");
		System.out.println("전화번호 : " +choi.getPhoneNum());
		
		System.out.println();
		
		Woman park = new Woman();
		Woman lee = new Woman(26);
		Woman jung = new Woman(26,163);
		Woman oh = new Woman(26,163,45);
		Woman hong = new Woman(26,163,45,"010-1234-5678");
		Woman leesangmin = new Woman(24,183,100,"010-2549-4022","리상민");
		
		System.out.print(hong.getAge()+ " 살\t ");
		System.out.println(hong.getHeight()+ " cm ");
		System.out.print(hong.getWeight()+ " kg \t");
		System.out.println("전화번호 : " +hong.getPhoneNum());
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		// leesangmin 출력
		System.out.println("이름은 : "+leesangmin.getName());
		System.out.print(leesangmin.getAge()+ " 살\t ");
		System.out.println(leesangmin.getHeight()+ " cm ");
		System.out.print(leesangmin.getWeight()+ " kg \t");
		System.out.println("전화번호 : " +leesangmin.getPhoneNum());
		
		
	} // Man 매개변수에 String name 도 넣어서 이름까지 해보기 .


}
