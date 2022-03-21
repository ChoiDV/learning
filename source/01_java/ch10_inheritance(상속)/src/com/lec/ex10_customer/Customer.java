package com.lec.ex10_customer;

// name, tel, address, sum, point, date, vip
// Customer c = new Customer("�̸�","��ȭ��ȣ","�ּ�","����");
public class Customer extends Person {
	private String address; // �ּ�
	private int sum; // �ݾ� ����
	private int point; // ����Ʈ(���Ÿ��� 5% ����)
	private String date; // �����( ����, ��ȥ����� ...) // Date Ÿ���� �� ���� ���߿�
	private boolean vip; // ��� true�� vip, false�� �Ϲ�

	public Customer(String name, String tel, String address, String date) {
		super(name, tel); // �ݵ�� ù��° �ٿ� �;���.
		this.address = address;
		this.date = date;
		point = 1000; // ���� ȸ�������� �����Դ� 1000����Ʈ �ڵ� �ο�
		// sum,vip�� �˾Ƽ� 0�� false�� �ʱ�ȭ��.
		System.out.println(name + " �� �����մϴ�. ����Ʈ 1000���� ������ �帳�ϴ�.");
	}

	public void buy(int price) { // c.buy(10000)
		sum += price;
		int tempPoint = ((int) (price * 0.05));
		point += tempPoint;
		System.out.println(getName() + " �� �����մϴ�. �̹� ���ŷ� ����Ʈ : " + tempPoint + " �� �߰��Ǿ� �� ����Ʈ : " + point + " �� �Դϴ�.");
		if(sum >= 1000000 && vip==false) {
			vip = true;  // ���� ���� �ݾ��� 100���� �̻�� vip������ ����
			System.out.println(getName()+" �� VIP ������ ���׷��̵� �Ǽ̽��ϴ�.");
		} 
	}
	// c.print() vs sysout(c.infoString()) vs sysout(c) �������̵� ������� toString ��
	@Override  // @ : ������̼�
	public String infoString() {
		return super.infoString() + " [�ּ�] " +address + " [����Ʈ] " + point + " [���� �ݾ�] " + sum;
	}

}
