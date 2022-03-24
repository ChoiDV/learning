package singleton1;

public class TestMain {

	public static void main(String[] args) {
		SingletonClass obj1 = SingletonClass.getInstance();
		SingletonClass obj2 = SingletonClass.getInstance();
		
		obj1.setI(99);		
		System.out.println("obj1의 i : "+obj1.getI());
		System.out.println("obj2의 i : "+obj2.getI());
		obj2.setI(10);
		System.out.println("obj1의 i : "+ obj1.getI());
		System.out.println("obj2의 i : "+ obj2.getI());
		// 지금은 싱글톤 패턴이 아니라 따로따로
		// 이미 만들어져있는데서 싱글톤 패턴으로 만들면 obj2 가 1가 같아짐

	}

}
