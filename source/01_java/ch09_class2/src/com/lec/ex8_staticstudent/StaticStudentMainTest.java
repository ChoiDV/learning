package com.lec.ex8_staticstudent;

public class StaticStudentMainTest {

	public static void main(String[] args) {

		StaticStudent line = new StaticStudent();

		line.fatLine();
		System.out.println("\t\t\t성적표");
		line.line();
		line.subjectPrint();
		line.line(); // 양식---------------------------------------------------------------------------

		StaticStudent jung = new StaticStudent("정우성", 90, 91, 91);
		StaticStudent kim = new StaticStudent("김하늘", 100, 80, 95);
		StaticStudent hwang = new StaticStudent("황정민", 95, 80, 90);
		StaticStudent gang = new StaticStudent("강동원", 95, 90, 99);
		StaticStudent yu = new StaticStudent("유아인", 90, 90, 80);

		StaticStudent[] student = { jung, kim, hwang, gang, yu };
		int[] sum = new int[5];
		int[] average = new int[5];

		for (int idx = 0; idx < student.length; idx++) {
			student[idx].countPrint(); // 번호 출력
			student[idx].resultPrint();
			sum[0] += student[idx].getKorean();
			sum[1] += student[idx].getEnglish();
			sum[2] += student[idx].getMath();
			sum[3] += student[idx].getSum();
			sum[4] += student[idx].getAverage();
		}

		line.line(); // 양식

		for (int idx = 0; idx < average.length; idx++) {
			//average[idx] = (sum[idx] / student.length);  // 버림 
			average[idx] = (int)(sum[idx]/(double)student.length+0.5);  // 반올림 하는 방법 
			// average[idx] = (int)Math.round(sum[idx]/(double)student.length);
		}

		System.out.print("    총점");

		for (int t : sum) {
			System.out.print("   \t" + t);
			//System.out.printf("$4d\t",t);
		}
		System.out.print("\n    평균");

		for (int t : average) {
			System.out.print("  \t" + t);
			//System.out.printf("%5.1f",t);
		}

		System.out.println();
		line.fatLine();

	}

}
