package com.lec.ex08_staticstudent;

public class StaticStudentMainTest {

	public static void main(String[] args) {

		StaticStudent line = new StaticStudent();

		line.fatLine();
		System.out.println("\t\t\t����ǥ");
		line.line();
		line.subjectPrint();
		line.line(); // ���---------------------------------------------------------------------------

		StaticStudent jung = new StaticStudent("���켺", 90, 91, 91);
		StaticStudent kim = new StaticStudent("���ϴ�", 100, 80, 95);
		StaticStudent hwang = new StaticStudent("Ȳ����", 95, 80, 90);
		StaticStudent gang = new StaticStudent("������", 95, 90, 99);
		StaticStudent yu = new StaticStudent("������", 90, 90, 80);

		StaticStudent[] student = { jung, kim, hwang, gang, yu };
		int[] sum = new int[5];
		int[] average = new int[5];

		for (int idx = 0; idx < student.length; idx++) {
			student[idx].countPrint(); // ��ȣ ���
			student[idx].resultPrint();
			sum[0] += student[idx].getKorean();
			sum[1] += student[idx].getEnglish();
			sum[2] += student[idx].getMath();
			sum[3] += student[idx].getSum();
			sum[4] += student[idx].getAverage();
		}

		line.line(); // ���

		for (int idx = 0; idx < average.length; idx++) {
			//average[idx] = (sum[idx] / student.length);  // ���� 
			average[idx] = (int)(sum[idx]/(double)student.length+0.5);  // �ݿø� �ϴ� ��� 
			// average[idx] = (int)Math.round(sum[idx]/(double)student.length);
		}

		System.out.print("    ����");

		for (int t : sum) {
			System.out.print("   \t" + t);
			//System.out.printf("$4d\t",t);
		}
		System.out.print("\n    ���");

		for (int t : average) {
			System.out.print("  \t" + t);
			//System.out.printf("%5.1f",t);
		}

		System.out.println();
		line.fatLine();

	}

}
