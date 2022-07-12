package singleton1;

public class SingletonClass {
	private int i;
	// ��ü ���� ������ �� ��ü �ּҸ� return �ϰ�
	// ��ü���� �������� ��ü �����ؼ� �� �ּҸ� return
	private static SingletonClass INSTANCE = new SingletonClass();
	 // ��ü�����Ϸ��� �� �޼ҵ� ȣ���ϱ� INSTANCE�� null �̸� ���� ����� ���� ������ return 
	public static SingletonClass getInstance() {
		return INSTANCE;
	}
		
	
	private SingletonClass() {	
	}
//	public SingletonClass() { //  �⺻ ������
//		
//	}
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

}
