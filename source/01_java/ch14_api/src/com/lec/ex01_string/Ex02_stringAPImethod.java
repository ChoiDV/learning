package com.lec.ex01_string;

public class Ex02_stringAPImethod {
	public static void main(String[] args) {
		String str1 = "abcXabc";
		String str2 = new String("ABCXabc");
		String str3 = "      ja    va   ";
		// ÀÚ¹Ù´Â Ç×»ó 0ºÎÅÍ ½ÃÀÛ
		System.out.println("1. "+str1.concat(str2)); // str1 + str2  = abcXabcABCXabc  ½ºÆ®¸µ µÎ°³ ´õÇØÁÖ´Â°Í .concat
		System.out.println("2. "+str1.substring(3)); // .substring(n) = n¹øÂ° ¼ıÀÚºÎÅÍ ³¡±îÁö Ãâ·Â. ±Ùµ¥ n¹ø¤Š¼ıÀÚ´Â 0¹øºÎÅÍ ½ÃÀÛÀÓ
		// ex)   "hello" ÀÖÀ¸¸é h=0 e=1 l=2 l=3 o=4 ÀÌ·±½ÄÀ¸·Î 1¹øºÎÅÍ½ÃÀÛÀÌ ¾Æ´Ï¶ó 0¹øºÎÅÍ ½ÃÀÛ
		System.out.println("3. "+str1.substring(3,5)); // 3¹øÂ°ºÎÅÍ 5¹øÂ° ¾Õ±îÁö  Xa
		// .substring(n,m) = n¹øÂ°ºÎÅÍ m¹øÂ° ¾Õ±îÁö 
		System.out.println("4. "+str1.length());  // .length ±ÛÀÚ ±æÀÌ 
		System.out.println("5. "+str1.toUpperCase()); // ´ë¹®ÀÚ·Î º¯È¯ ABCXABC
		System.out.println("6. "+str1.toLowerCase()); // ¼Ò¹®ÀÚ·Î º¯È¯ abcxabc
		System.out.println("7. "+str1.charAt(3)); // 3¹øÂ° ¹®ÀÚ¸¦ ¹İÈ¯ 'x'
		
		System.out.println("8. "+str1.indexOf('b')); // Ã¹¹øÂ° 'b'°¡ ³ª¿À´Â ÀÎµ¦½º 1
		System.out.println("9. "+str1.indexOf('b',3)); // 3¹øÂ°ºÎÅÍ °Ë»öÇØ¼­ Ã¹¹øÂ° bÀÇ À§Ä¡ 5
		System.out.println("10. "+str1.indexOf("abc")); //  Ã¹¹øÂ° "abc"°¡ ³ª¿À´Â À§Ä¡  0
		System.out.println("11. "+str1.indexOf("abc",3)); // 3¹øÂ°ºÎÅÍ °Ë»öÇØ¼­ "abc" À§Ä¡ 4
		System.out.println("12. "+str1.indexOf('z')); // ¾øÀ¸¸é -1 ¸®ÅÏ
		System.out.println("13. "+str1.lastIndexOf('b')); // ¸¶Áö¸·'b'ÀÇ À§Ä¡  À§Ä¡ 
		System.out.println("14. "+str1.lastIndexOf('b',3));  // 3¹øÂ°ºÎÅÍ ¸Ç ¸¶Áö¸· bÀÇ À§Ä¡ 1
		
		System.out.println("15. "+str1.equals(str2));  // str1 °ú str2 °¡ °°Àº ¹®ÀÚ¿­ÀÎÁö false
		System.out.println("16. "+str1.equalsIgnoreCase(str2)); // ´ë¼Ò¹®ÀÚ ±¸ºĞÇÏÁö¾Ê°í str1°ú str2°¡ °°Àº ¹®ÀÚ¿­ÀÎÁö ±×·¡¼­ true
		
		str1 = "abcXabc";
		str2 = new String("ABCXabc");
		str3 = "      ja    va   ";
		
		System.out.println("17. "+str3.trim()); // ¾Õ,µÚ °ø¹éÀ» Á¦°Å      ja  va
		System.out.println("18. "+str1.replace('a','9'));  // a¸¦ 9·Î ¼öÁ¤ÇØ¶ó   9bcX9bc
		System.out.println("19. "+str1.replace("abc","#")); // "abc"¸¦  "#" À¸·Î ¹Ù²ã¶ó
		System.out.println("20. str3ÀÇ space¸¦ ¾ø¾Ö±â "+str3.replace(" ",""));  // ½ºÆäÀÌ½º ÇÏ³ª¸¦ ¾ø¾Ö±â
		System.out.println("21. "+str1.replaceAll("abc", "Z")); // "abc"¸¦ "Z"·Î ¹Ù²ã¶ó
		System.out.println("22. "+str1.replace("abc", "Z")); 	// "abc"¸¦ "Z"·Î ¹Ù²ã¶ó  
		/* Á¤±ÔÇ¥Çö½Ä :  https://goo.gl/HLntbd
		 *  ¿¬½ÀÀå : http://www.nextree.co.kr/p4327		 
		 */
		String str = "¾È³çHello";
		System.out.println("23. "+str.replaceAll("[a-zA-Z]",""));  // ¾ËÆÄºªÀ» ""·Î ¼öÁ¤
		System.out.println("24. "+str.replaceAll("[°¡-ÆR]", ""));  // ÇÑ±Û¹®ÀÚ¸¦ "" ·Î ¼öÁ¤
		
		// ¹®ÀÚ¿­ ¸Ş¼Òµå´Â ¹®ÀÚ¿­À» ¼öÁ¤ ¾ÈÇÔ
		// ÁøÂ¥ strÀ» ¹Ù²Ù´Â°ÍÀÌ ¾Æ´Ô
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		// ÇÏ³ªµµ ¾È¹Ù²ñ
		
		
		
		
		
	}
}
