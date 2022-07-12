package com.lec.customer;

import java.sql.Date;

public class CustomerDto {
	private String cId;
	private String cPw;
	private String cName;
	private String cTel;
	private String cEmail;
	private String cAddress;
	private String cGender;
	private Date cBirth;
	private Date cRdate;
	
	public CustomerDto() {}

	public CustomerDto(String cId, String cPw, String cName, String cTel, String cEmail, String cAddress,
			String cGender, Date cBirth, Date cRdate) {
		this.cId = cId;
		this.cPw = cPw;
		this.cName = cName;
		this.cTel = cTel;
		this.cEmail = cEmail;
		this.cAddress = cAddress;
		this.cGender = cGender;
		this.cBirth = cBirth;
		this.cRdate = cRdate;
	}

	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}

	public String getcPw() {
		return cPw;
	}

	public void setcPw(String cPw) {
		this.cPw = cPw;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcTel() {
		return cTel;
	}

	public void setcTel(String cTel) {
		this.cTel = cTel;
	}

	public String getcEmail() {
		return cEmail;
	}

	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}

	public String getcAddress() {
		return cAddress;
	}

	public void setcAddress(String cAddress) {
		this.cAddress = cAddress;
	}

	public String getcGender() {
		return cGender;
	}

	public void setcGender(String cGender) {
		this.cGender = cGender;
	}

	public Date getcBirth() {
		return cBirth;
	}

	public void setcBirth(Date cBirth) {
		this.cBirth = cBirth;
	}

	public Date getcRdate() {
		return cRdate;
	}

	public void setcRdate(Date cRdate) {
		this.cRdate = cRdate;
	}

	@Override
	public String toString() {
		return "customerDto [cId=" + cId + ", cPw=" + cPw + ", cName=" + cName + ", cTel=" + cTel + ", cEmail=" + cEmail
				+ ", cAddress=" + cAddress + ", cGender=" + cGender + ", cBirth=" + cBirth + ", cRdate=" + cRdate + "]";
	}
	
	
	
	
	
}
