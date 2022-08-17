package com.lec.ex01_student;

public class StudentTestMain {

	public static void main(String[] args) {

		Student line = new Student();

		line.fatLine(); // ���
		System.out.println("\t\t����ǥ"); // ���
		line.line(); // ���
		line.subjectPrint(); // ���
		line.line(); // ���

		Student jung = new Student("���켺", 90, 90, 90); // jung�� student[0]��
		Student kim = new Student("���ϴ�", 90, 90, 91); // kim�� student[1]�� �̷��� �Ǵ°��̰�
		Student hwang = new Student("Ȳ����", 81, 80, 80); // [3]
		Student gang = new Student("������", 80, 80, 80); // [4]
		Student yu = new Student("������", 70, 70, 70); // [5]

		Student[] student = { jung, kim, hwang, gang, yu };
		int[] sum = new int[5];         // ������ �־���  sum �迭
		double[] average = new double[5];	// ����� �־��� average �迭

		for (int idx = 0; idx < student.length; idx++) { // sum �� ���� �������� �ִ°���.
			student[idx].resultPrint();
			sum[0] += student[idx].getKorean();
			sum[1] += student[idx].getEnglish();
			sum[2] += student[idx].getMath();
			sum[3] += student[idx].getSum();
			sum[4] += student[idx].getAverage();
		}
//		for(Student s : student) {     // Ȯ�� for�� ������� ���.
//			s.resultPrint(); 
//			sum[0] += s.getKorean();    
//			sum[1] += s.getEnglish();
//			sum[2] += s.getMath();
//			sum[3] += s.getSum();
//			sum[4] += s.getAverage();
//		}
		for (int idx = 0; idx < average.length; idx++) { // average[0]���� sum[0]�� student.length�� �������� �� ���� ����/�л��� = ��� ��
															// �־��ִ� �۾�
			average[idx] = (sum[idx] / student.length); // �׷��� average[3]���� sum[3]�� 5�� ���� �� �� ����/�л��� = ��� �� �־��ִ� �۾��̴�.
		}
		line.line(); // ----��
		
		System.out.print("    ����"); // ����(sum) ����ϱ�
		for (int idx = 0; idx < sum.length; idx++) {
			System.out.print("\t" + sum[idx]);
		}
//		 for(int t : sum) {        			// Ȯ�� for���� �̿��� ����(sum) ����ϱ�
//			System.out.print("\t"+t);
//		}
		
		System.out.print("\n    ���");
		for (int idx = 0; idx < average.length; idx++) { // ���(average) ����ϱ�
			System.out.print("\t" + average[idx]);
		}
//		for(double t : average) {			// Ȯ�� for���� �̿��� ���(average) ����ϱ�
//			System.out.print("\t"+t);			
//		}
		System.out.println();
		line.fatLine(); // ������ ��

	}

}
