// Hello.java --(컴파일)---> Hello.class --(실행 java Hello)--> 결과
public class Hello {
	public static void main(String[] args) {
		
		System.out.print("안녕하세요");
		
		for(int idx=0; idx<args.length; idx++) {
			System.out.print(" , " + args[idx]);
			
		}
	}
}
