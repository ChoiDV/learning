
public class Car2Test {

	public static void main(String[] args) {
		
		Car2 c1 = new Car2("S600","white", 80);
		Car2 c2 = new Car2("E500","blue",20);
		// Car2 c3 = new Car2("����","���",200);
		
		
		int n = Car2.getNumberOfcars();  // ���� �޼ҵ� ȣ��     //Ŭ�����̸� ���� ȣ���ϸ��.
		System.out.println("���ݱ��� ������ �ڵ��� �� = " +n);     //���� ��ü�� ����� �����
		double value =Math.sqrt(4.0);
		System.out.println(value);
		
		
		
		
		
		
		
		
		
		// �̰Ŵ� static ��� �����Ҷ� �� 
		/*
		int n = Car2.numbers;          // ���� ���� ��ü�̸��� �ƴ� Ŭ���� �̸��� ���°��̴������
		System.out.println("���ݱ��� ������ �ڵ��� �� = " +n);
		*/
	
		

	}

}
