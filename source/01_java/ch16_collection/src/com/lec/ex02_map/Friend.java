package com.lec.ex02_map;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Friend {
	private String name;
	private String tel;
	private Date birth;

	public Friend() {
	}

	public Friend(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}

	public Friend(String name, String tel, Date birth) {
		this.name = name;
		this.tel = tel;
		this.birth = birth;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("  ���� : MM��dd��");
		if (birth != null) {
			return "�̸� : " + name + "  ��ȭ��ȣ : " + tel + sdf.format(birth);
		} else {
			return "�̸� : " + name + "  ��ȭ��ȣ : " + tel;
		}
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

}
