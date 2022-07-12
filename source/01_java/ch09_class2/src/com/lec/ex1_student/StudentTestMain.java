package com.lec.ex1_student;

public class StudentTestMain {

	public static void main(String[] args) {

		Student line = new Student();

		line.fatLine();
		System.out.println("\t\t성적표");
		line.line();
		line.subjectPrint();
		line.line(); // 양식---------------------------------------------------------------------------
		
			// 스캐너로 내가 값들 직접 입력해보기.	
		Student jung = new Student("정우성", 90, 90, 90);
		Student kim = new Student("김하늘", 90, 90, 91);
		Student hwang = new Student("황정민", 81, 80, 80);
		Student gang = new Student("강동원", 80, 80, 80);
		Student yu = new Student("유아인", 70, 70, 70);

		Student[] student = { jung, kim, hwang, gang, yu };
		int[] sum = new int[5]; // 총점 넣을곳
		double[] average = new double[5]; // 평균 넣을곳

		for (int idx = 0; idx < student.length; idx++) {
			student[idx].resultPrint(); // student들을 출력해주고
			sum[0] += student[idx].getKorean(); // 각각의 값들을 sum에 넣는다.
			sum[1] += student[idx].getEnglish();
			sum[2] += student[idx].getMath();
			sum[3] += student[idx].getSum();
			sum[4] += student[idx].getAverage();
		}
//			for( Student s : student) {     // 확장 for문
//			s.resultPrint();
//			sum[0] += s.getKorean();
//			sum[1] += s.getEnglish();
//			sum[2] += s.getMath();
//			sum[3] += s.getSum();
//			sum[4] += s.getAverage();
//		}

		line.line(); // 양식

		for (int idx = 0; idx < average.length; idx++) { // average 에 평균값 넣기
			average[idx] = ((double) sum[idx] / student.length);
		}

		System.out.print("    총점"); // 총점 양식
		for (int idx = 0; idx < sum.length; idx++) {
			System.out.print("\t" + sum[idx]);
		}
//		for(int t: sum) {
//			System.out.print("\t"+t);		
//		}
		System.out.print("\n    평균"); // 평균 양식
		for (int idx = 0; idx < average.length; idx++) { //
			System.out.print("\t" + average[idx]);
		}
//		for(double t : average) {
//			System.out.print("\t"+t);
//		}

		System.out.println(); // 개행
		line.fatLine(); // 두꺼운 선

	}

}
