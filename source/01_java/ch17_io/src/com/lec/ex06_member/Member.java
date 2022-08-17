package com.lec.ex06_member;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Member {
	private String name;
	private String tel;
	private Date birthday;
	private String address;
	private Date today;
	SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");

	public Member() {
	}

	public Member(String name, String tel, Date birthday, String address) {
		this.name = name;
		this.tel = tel;
		this.birthday = birthday;
		this.address = address;
	}

	@Override
	public String toString() {
		return name + "  " + tel + "  " + sdf.format(birthday) + "»ý   " + address;

	}

	public Date getBirthday() {
		return birthday;
	}

}
