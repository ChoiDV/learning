
public class ArrayProcTest {

	public static void main(String[] args) {
		
		int[] list = {1,2,3,4,5};
		ArrayProc obj = new ArrayProc();
		for (int i =0; i < list.length; i++)
			System.out.print(list[i] + " ");
		System.out.println(" ");
		obj.inc(list);      // 이게 +시키는 요인
		
		for ( int i =0; i < list.length; i++)
			System.out.print(list[i] + " ");
		
		

	}

}

