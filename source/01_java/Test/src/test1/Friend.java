package test1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Friend {
	private String name;
	private String phone;
	private String address;
	private Date birthday;
	SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");

	public Friend() {
	}

	public Friend(String name, String phone, String address, Date birthday) {
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "�̸� : " + name + "\n�ּ� : " + address + "\n�ڵ��� ��ȣ : " + phone + "\n���� : " + sdf.format(birthday) + "\n";
	}

	public String getAddress() {
		return address;
	}
}
