
public class ArrayProcTest2 {

	final static int STUDENTS = 5;
	
	public static void main(String[] args) {
		
		int[] scores = new int[STUDENTS];
		ArrayProc2 obj = new ArrayProc2();
		obj.getValues(scores);
		double average=obj.getAverage(scores);
		System.out.println("����� = " + average);
		//System.out.println("����� = " +obj.getAverage(scores));
		
		
		
	}

}
