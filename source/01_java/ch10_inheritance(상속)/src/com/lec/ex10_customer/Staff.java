package com.lec.ex10_customer;
// name, tel �� �̹� Person�� �ְ�  ,  hiredate(�Ի���), department(�μ�)
// Staff s = new Staff("�̸�","��ȣ","�Ի���","�μ�");
public class Staff extends Person {
	private String hiredate;
	private String department;
	
	public Staff(String name, String tel, String hiredate, String department) {
		super(name, tel);
		this.hiredate = hiredate;
		this.department = department;
		System.out.println(getName() + " �� �� ��ȭ��ȣ�� : "+getTel()+ " �Ի��� : " + hiredate + " �μ��� : "+ department);
		
	}
	// sysout(s.infoString) - [�̸�] [��ȭ��ȣ] [�Ի���] [�μ�] ���
	@Override
	public String infoString() {
		return super.infoString() + " [�Ի���] "+ hiredate + " [�μ�] " + department;
	}
	
	
	
	
	

}
