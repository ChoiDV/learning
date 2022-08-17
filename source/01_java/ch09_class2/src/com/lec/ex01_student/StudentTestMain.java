package com.lec.ex01_student;

public class StudentTestMain {

	public static void main(String[] args) {

		Student line = new Student();

		line.fatLine(); // 양식
		System.out.println("\t\t성적표"); // 양식
		line.line(); // 양식
		line.subjectPrint(); // 양식
		line.line(); // 양식

		Student jung = new Student("정우성", 90, 90, 90); // jung은 student[0]번
		Student kim = new Student("김하늘", 90, 90, 91); // kim은 student[1]번 이렇게 되는것이고
		Student hwang = new Student("황정민", 81, 80, 80); // [3]
		Student gang = new Student("강동원", 80, 80, 80); // [4]
		Student yu = new Student("유아인", 70, 70, 70); // [5]

		Student[] student = { jung, kim, hwang, gang, yu };
		int[] sum = new int[5];         // 총점을 넣어줄  sum 배열
		double[] average = new double[5];	// 평균을 넣어줄 average 배열

		for (int idx = 0; idx < student.length; idx++) { // sum 에 과목별 총점들을 넣는과정.
			student[idx].resultPrint();
			sum[0] += student[idx].getKorean();
			sum[1] += student[idx].getEnglish();
			sum[2] += student[idx].getMath();
			sum[3] += student[idx].getSum();
			sum[4] += student[idx].getAverage();
		}
//		for(Student s : student) {     // 확장 for문 사용했을 경우.
//			s.resultPrint(); 
//			sum[0] += s.getKorean();    
//			sum[1] += s.getEnglish();
//			sum[2] += s.getMath();
//			sum[3] += s.getSum();
//			sum[4] += s.getAverage();
//		}
		for (int idx = 0; idx < average.length; idx++) { // average[0]에는 sum[0]을 student.length로 나눈값을 즉 국어 총점/학생수 = 평균 을
															// 넣어주는 작업
			average[idx] = (sum[idx] / student.length); // 그러면 average[3]에는 sum[3]을 5로 나눈 값 즉 총점/학생수 = 평균 을 넣어주는 작업이다.
		}
		line.line(); // ----선
		
		System.out.print("    총점"); // 총점(sum) 출력하기
		for (int idx = 0; idx < sum.length; idx++) {
			System.out.print("\t" + sum[idx]);
		}
//		 for(int t : sum) {        			// 확장 for문을 이용한 총점(sum) 출력하기
//			System.out.print("\t"+t);
//		}
		
		System.out.print("\n    평균");
		for (int idx = 0; idx < average.length; idx++) { // 평균(average) 출력하기
			System.out.print("\t" + average[idx]);
		}
//		for(double t : average) {			// 확장 for문을 이용한 평균(average) 출력하기
//			System.out.print("\t"+t);			
//		}
		System.out.println();
		line.fatLine(); // ■■■■■ 선

	}

}
