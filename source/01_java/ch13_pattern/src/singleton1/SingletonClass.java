package singleton1;

public class SingletonClass {
	private int i;
	// 객체 생성 했으면 그 객체 주소를 return 하고
	// 객체생성 안했으면 객체 생성해서 그 주소를 return
	private static SingletonClass INSTANCE = new SingletonClass();
	 // 객체생성하려면 이 메소드 호출하기 INSTANCE가 null 이면 새로 만들고 값이 있으면 return 
	public static SingletonClass getInstance() {
		return INSTANCE;
	}
		
	
	private SingletonClass() {	
	}
//	public SingletonClass() { //  기본 생성자
//		
//	}
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

}
