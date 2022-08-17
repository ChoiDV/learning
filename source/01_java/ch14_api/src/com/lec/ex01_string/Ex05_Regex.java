package com.lec.ex01_string;

public class Ex05_Regex {
	public static void main(String[] args) {
		
//		System.out.println("replace => "+ str.replace("0", "ȫ"));   // 0�� ȫ���� �ٲ�
		/* ���� ǥ���� (regex)
		 *  1.���� :  https://goo.gl/HLntbd
		 * 
		 *  2. ���� ����
		 *       \d (���ڿ� ��ġ, [0-9]�� ����)  \D(���ڰ� �ƴ� ��)
		 *       \s (whitespacen : space, ��, ����)
		 *       \w (�����ڳ� ����, [a-zA-Z0-9] �� ����) \W (�����ڳ� ���ڰ� �ƴ� ����)
		 *       . (���� �ϳ�)
		 *       + (1�� �̻� �ݺ�)
		 *       * (0�� �̻� �ݺ� )
		 *       ? (0~1�� �ݺ� ) 
		 *       {2,4} ( 2~4ȸ �ݺ�) 
		 */
				
		/*  3. ���� ǥ���� ������
		 *     https://regexr.com   
		 *     https://regexpal.com
		 *   ��ȭ��ȣ ���� ǥ����  .?[0-9]{2,3}.[0-9]{3,4}-[0-9]{4}	 
		 *   �̸��� : 
		 */	
		
		/*  4. Ʈ�� ����ǥ������ ���ڿ� ���� : replaceAll("����ǥ����", "��ü���ڿ�")
		 * 
		 * 
		 */
		
//		System.out.println(str.replaceAll("[0-9]", "X"));  // �� ����ǥ������ [0-9]�� ���ڸ� ����
//		System.out.println(str.replaceAll("\\d", "X"));  // ���� [0-9]�� ���� \\d �������� �ΰ� 
//		System.out.println(str.replaceAll("\\D", "X"));
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		String str = "010-4434-9878 chlwlsdud69@naver.com (02)565-8888 �ݰ����ϴ�.  ����Hello 000103-3025419  010-4434-9878";
		
		// ��ȭ��ȣ ����		
		System.out.println(str.replaceAll("[(]?[0-9]{2,3}\\D[0-9]{3,4}-[0-9]{4}","** ��ȭ��ȣ ���� **"));
	
		// �̸��� ����� 		
		System.out.println(str.replaceAll("[a-zA-Z0-9]+@\\w+.\\w+"," ** �̸��� ** "));
		System.out.println(str.replaceAll("\\w+@\\w+(.\\w+){1,2}"," ** �̸��� ** "));
		// ���ĺ� ��� *�� ��ü
		System.out.println(str.replaceAll("[a-zA-Z]", "*"));
		// �ѱ� �� �� ����
		System.out.println(str.replaceAll("[��-�R��-��]", ""));
		// �ֹι�ȣ ���ڸ��� *�� ��ü
		System.out.println(str.replaceAll("[0-9]{7}", "*******"));
		
	}
}
