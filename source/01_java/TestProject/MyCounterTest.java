
public class MyCounterTest {

	public static void main(String[] args) {
		
		MyCounter obj = new MyCounter();
		int x = 10;
		
		obj.inc(x);
		System.out.println("x = " + x);
		
		System.out.println("x = " +obj.inc(x));
		//int a =obj.inc(x);
		//System.out.println("a =" + a);
		
		
	}

}
