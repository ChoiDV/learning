package com.lec.ex10_customer;
// name, tel 은 이미 Person에 있고  ,  hiredate(입사일), department(부서)
// Staff s = new Staff("이름","번호","입사일","부서");
public class Staff extends Person {
	private String hiredate;
	private String department;
	
	public Staff(String name, String tel, String hiredate, String department) {
		super(name, tel);
		this.hiredate = hiredate;
		this.department = department;
		System.out.println(getName() + " 님 의 전화번호는 : "+getTel()+ " 입사일 : " + hiredate + " 부서는 : "+ department);
		
	}
	// sysout(s.infoString) - [이름] [전화번호] [입사일] [부서] 출력
	@Override
	public String infoString() {
		return super.infoString() + " [입사일] "+ hiredate + " [부서] " + department;
	}
	
	
	
	
	

}
