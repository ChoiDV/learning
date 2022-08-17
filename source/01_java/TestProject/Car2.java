
public class Car2 {
	private String model;
	private String color;
	private int speed;
	
	//자동차의 시리얼 번호
	private int id;
	static int numbers = 0;
	
	public Car2(String m, String c, int s) {
		model = m;
		color = c;
		speed = s;
		
		 // 자동차의 개수를 증가하고 id에 대입한다.


		id = ++numbers;
		
		// numbers 가 공유변수여서  
		// Car2 가 다른곳에서 선언될때마다 ++numbers 됌.
	}
	
	//정적 메소드
	
	public static int getNumberOfcars() {
		return numbers;
	}

}
