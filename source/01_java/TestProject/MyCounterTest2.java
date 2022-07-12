
public class MyCounterTest2 {

	public static void main(String[] args) {


		MyCounter2 obj = new MyCounter2();
		
		System.out.println("obj.value = " + obj.value);
		obj.inc(obj);
		System.out.println("obj.value = " + obj.value);
		

	}

}
