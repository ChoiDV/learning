
public class Car2 {
	private String model;
	private String color;
	private int speed;
	
	//�ڵ����� �ø��� ��ȣ
	private int id;
	static int numbers = 0;
	
	public Car2(String m, String c, int s) {
		model = m;
		color = c;
		speed = s;
		
		 // �ڵ����� ������ �����ϰ� id�� �����Ѵ�.


		id = ++numbers;
		
		// numbers �� ������������  
		// Car2 �� �ٸ������� ����ɶ����� ++numbers ��.
	}
	
	//���� �޼ҵ�
	
	public static int getNumberOfcars() {
		return numbers;
	}

}
