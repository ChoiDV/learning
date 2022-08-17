package com.lec.ex01_string;

public class Ex02_stringAPImethod {
	public static void main(String[] args) {
		String str1 = "abcXabc";
		String str2 = new String("ABCXabc");
		String str3 = "      ja    va   ";
		// �ڹٴ� �׻� 0���� ����
		System.out.println("1. "+str1.concat(str2)); // str1 + str2  = abcXabcABCXabc  ��Ʈ�� �ΰ� �����ִ°� .concat
		System.out.println("2. "+str1.substring(3)); // .substring(n) = n��° ���ں��� ������ ���. �ٵ� n�������ڴ� 0������ ������
		// ex)   "hello" ������ h=0 e=1 l=2 l=3 o=4 �̷������� 1�����ͽ����� �ƴ϶� 0������ ����
		System.out.println("3. "+str1.substring(3,5)); // 3��°���� 5��° �ձ���  Xa
		// .substring(n,m) = n��°���� m��° �ձ��� 
		System.out.println("4. "+str1.length());  // .length ���� ���� 
		System.out.println("5. "+str1.toUpperCase()); // �빮�ڷ� ��ȯ ABCXABC
		System.out.println("6. "+str1.toLowerCase()); // �ҹ��ڷ� ��ȯ abcxabc
		System.out.println("7. "+str1.charAt(3)); // 3��° ���ڸ� ��ȯ 'x'
		
		System.out.println("8. "+str1.indexOf('b')); // ù��° 'b'�� ������ �ε��� 1
		System.out.println("9. "+str1.indexOf('b',3)); // 3��°���� �˻��ؼ� ù��° b�� ��ġ 5
		System.out.println("10. "+str1.indexOf("abc")); //  ù��° "abc"�� ������ ��ġ  0
		System.out.println("11. "+str1.indexOf("abc",3)); // 3��°���� �˻��ؼ� "abc" ��ġ 4
		System.out.println("12. "+str1.indexOf('z')); // ������ -1 ����
		System.out.println("13. "+str1.lastIndexOf('b')); // ������'b'�� ��ġ  ��ġ 
		System.out.println("14. "+str1.lastIndexOf('b',3));  // 3��°���� �� ������ b�� ��ġ 1
		
		System.out.println("15. "+str1.equals(str2));  // str1 �� str2 �� ���� ���ڿ����� false
		System.out.println("16. "+str1.equalsIgnoreCase(str2)); // ��ҹ��� ���������ʰ� str1�� str2�� ���� ���ڿ����� �׷��� true
		
		str1 = "abcXabc";
		str2 = new String("ABCXabc");
		str3 = "      ja    va   ";
		
		System.out.println("17. "+str3.trim()); // ��,�� ������ ����      ja  va
		System.out.println("18. "+str1.replace('a','9'));  // a�� 9�� �����ض�   9bcX9bc
		System.out.println("19. "+str1.replace("abc","#")); // "abc"��  "#" ���� �ٲ��
		System.out.println("20. str3�� space�� ���ֱ� "+str3.replace(" ",""));  // �����̽� �ϳ��� ���ֱ�
		System.out.println("21. "+str1.replaceAll("abc", "Z")); // "abc"�� "Z"�� �ٲ��
		System.out.println("22. "+str1.replace("abc", "Z")); 	// "abc"�� "Z"�� �ٲ��  
		/* ����ǥ���� :  https://goo.gl/HLntbd
		 *  ������ : http://www.nextree.co.kr/p4327		 
		 */
		String str = "�ȳ�Hello";
		System.out.println("23. "+str.replaceAll("[a-zA-Z]",""));  // ���ĺ��� ""�� ����
		System.out.println("24. "+str.replaceAll("[��-�R]", ""));  // �ѱ۹��ڸ� "" �� ����
		
		// ���ڿ� �޼ҵ�� ���ڿ��� ���� ����
		// ��¥ str�� �ٲٴ°��� �ƴ�
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		// �ϳ��� �ȹٲ�
		
		
		
		
		
	}
}
