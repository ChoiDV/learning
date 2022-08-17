package com.lec.ex1_student;

public class StudentTestMain {

	public static void main(String[] args) {

		Student line = new Student();

		line.fatLine();
		System.out.println("\t\t����ǥ");
		line.line();
		line.subjectPrint();
		line.line(); // ���---------------------------------------------------------------------------
		
			// ��ĳ�ʷ� ���� ���� ���� �Է��غ���.	
		Student jung = new Student("���켺", 90, 90, 90);
		Student kim = new Student("���ϴ�", 90, 90, 91);
		Student hwang = new Student("Ȳ����", 81, 80, 80);
		Student gang = new Student("������", 80, 80, 80);
		Student yu = new Student("������", 70, 70, 70);

		Student[] student = { jung, kim, hwang, gang, yu };
		int[] sum = new int[5]; // ���� ������
		double[] average = new double[5]; // ��� ������

		for (int idx = 0; idx < student.length; idx++) {
			student[idx].resultPrint(); // student���� ������ְ�
			sum[0] += student[idx].getKorean(); // ������ ������ sum�� �ִ´�.
			sum[1] += student[idx].getEnglish();
			sum[2] += student[idx].getMath();
			sum[3] += student[idx].getSum();
			sum[4] += student[idx].getAverage();
		}
//			for( Student s : student) {     // Ȯ�� for��
//			s.resultPrint();
//			sum[0] += s.getKorean();
//			sum[1] += s.getEnglish();
//			sum[2] += s.getMath();
//			sum[3] += s.getSum();
//			sum[4] += s.getAverage();
//		}

		line.line(); // ���

		for (int idx = 0; idx < average.length; idx++) { // average �� ��հ� �ֱ�
			average[idx] = ((double) sum[idx] / student.length);
		}

		System.out.print("    ����"); // ���� ���
		for (int idx = 0; idx < sum.length; idx++) {
			System.out.print("\t" + sum[idx]);
		}
//		for(int t: sum) {
//			System.out.print("\t"+t);		
//		}
		System.out.print("\n    ���"); // ��� ���
		for (int idx = 0; idx < average.length; idx++) { //
			System.out.print("\t" + average[idx]);
		}
//		for(double t : average) {
//			System.out.print("\t"+t);
//		}

		System.out.println(); // ����
		line.fatLine(); // �β��� ��

	}

}
