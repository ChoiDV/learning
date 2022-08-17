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
		SimpleDateFormat sdf = new SimpleDateFormat("  생일 : MM월dd일");
		if (birth != null) {
			return "이름 : " + name + "  전화번호 : " + tel + sdf.format(birth);
		} else {
			return "이름 : " + name + "  전화번호 : " + tel;
		}
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

}
