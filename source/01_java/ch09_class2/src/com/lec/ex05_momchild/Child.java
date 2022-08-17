package com.lec.ex05_momchild;
// Child first = new Child("첫째");
// first.takeMoney(1000);

public class Child {
	private String name;
	static MomPouch momPouch;
	
	public Child() {		
	}
	
	public Child(String name) {
		this.name = name;
		momPouch = new MomPouch();
		
	}
	public void takeMoney(int money) {
		if(momPouch.money >= money) {
			momPouch.money -= money;
			System.out.println(name + "가 " + money + " 원 가져가서 엄마 지갑에  "+momPouch.money +" 원 있음");
		} else {
			System.out.println(name + "가 돈을 못받음. 현재 엄마 지갑에는 " + momPouch.money+" 원밖에 없음");
		}
	}
	
}
