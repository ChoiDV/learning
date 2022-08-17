package com.lec.ex10_customer;

// name, tel, address, sum, point, date, vip
// Customer c = new Customer("이름","전화번호","주소","생일");
public class Customer extends Person {
	private String address; // 주소
	private int sum; // 금액 누적
	private int point; // 포인트(구매마다 5% 적립)
	private String date; // 기념일( 생일, 결혼기념일 ...) // Date 타입이 될 예정 나중에
	private boolean vip; // 등급 true면 vip, false면 일반

	public Customer(String name, String tel, String address, String date) {
		super(name, tel); // 반드시 첫번째 줄에 와야함.
		this.address = address;
		this.date = date;
		point = 1000; // 새로 회원가입한 고객에게는 1000포인트 자동 부여
		// sum,vip는 알아서 0과 false로 초기화됨.
		System.out.println(name + " 님 감사합니다. 포인트 1000점을 선물로 드립니다.");
	}

	public void buy(int price) { // c.buy(10000)
		sum += price;
		int tempPoint = ((int) (price * 0.05));
		point += tempPoint;
		System.out.println(getName() + " 님 감사합니다. 이번 구매로 포인트 : " + tempPoint + " 점 추가되어 총 포인트 : " + point + " 점 입니다.");
		if(sum >= 1000000 && vip==false) {
			vip = true;  // 구매 누적 금액이 100만원 이상시 vip고객으로 변경
			System.out.println(getName()+" 님 VIP 고객으로 업그레이드 되셨습니다.");
		} 
	}
	// c.print() vs sysout(c.infoString()) vs sysout(c) 오버라이드 해줘야함 toString 을
	@Override  // @ : 어노테이션
	public String infoString() {
		return super.infoString() + " [주소] " +address + " [포인트] " + point + " [누적 금액] " + sum;
	}

}
