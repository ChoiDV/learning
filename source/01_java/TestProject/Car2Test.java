
public class Car2Test {

	public static void main(String[] args) {
		
		Car2 c1 = new Car2("S600","white", 80);
		Car2 c2 = new Car2("E500","blue",20);
		// Car2 c3 = new Car2("벤츠","흰색",200);
		
		
		int n = Car2.getNumberOfcars();  // 정적 메소드 호출     //클래스이름 쓰고 호출하면됌.
		System.out.println("지금까지 생성된 자동차 수 = " +n);     //원래 객체를 만들고 써야함
		double value =Math.sqrt(4.0);
		System.out.println(value);
		
		
		
		
		
		
		
		
		
		// 이거는 static 멤버 연습할때 쓴 
		/*
		int n = Car2.numbers;          // 정적 변수 객체이름이 아닌 클래스 이름을 쓰는것이당당당당당당
		System.out.println("지금까지 생성된 자동차 수 = " +n);
		*/
	
		

	}

}
