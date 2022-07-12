import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("수를 입력하세요 : ");
		int ggd = sc.nextInt();

		for (int i = 1; i < 10; i++) {
			System.out.println(ggd + " * " + i + " = " + (ggd * i));
		}
	}
}
