package com.lec.ex02_date;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.lec.ex01_string_friend.Friend;

public class Ex06_FriendsSimpleDateFormat {

	public static void main(String[] args) {
		
		Friend[] friends = { new Friend("ȫ�浿", "010-9999-9999", "05-22"),
				 new Friend("�ű浿", "010-8888-8888", "09-22"),
				 new Friend("���浿", "010-8888-9999", "08-22"), 
				 new Friend("���浿", "010-7777-7777", "03-28"),
				 new Friend("��浿", "010-6666-7777", "03-28") };
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		boolean searchOk = false;
		
		for(int i =0; i < friends.length; i++) {
			String birth = friends[i].getBirthday();
			if(birth.equals(sdf.format(date))) {
				System.out.println(friends[i].getName()+" �� ���� �����մϴ�");
				searchOk = true;
			} 
		}
		if( ! searchOk) {
			System.out.println("���� ������ ģ���� �����ϴ�.");
		}
		
		
		/* �˻��� ��ȭ��ȣ ���ڸ��� �Է¹޾� => �ý������κ��� ��¥�� �޾� "MM-dd" ��Ÿ���� string���� ��ȯ
		 * 0~������� �ش� ��ȭ��ȣ�� ������ ��� => 0~������� �ش� ���ϰ� ������ ��ȯ�� ��Ʈ�� "03-28" ������ ���
		 * �˻��� ���� �ʾ� ��� ���ϸ� ���µ� ��� ��� => �ش� �����ڰ� ���� ����� ���ϸ� ���µ���� ���
		 * 
		 */
	}

}
