package com.lec.ex3_student;

public class StudentDto {
	private String rank;
	private int sno;
	private String sname;
	private String mname;
	private int score;
	
	public StudentDto() {
	}
	
	public StudentDto(int sno) {		
		this.sno = sno;		
	}
	
	// 입력용
	public StudentDto(String sname, String mname, int score) {		
		this.sname = sname;
		this.mname = mname;
		this.score = score;
	}


	// 출력용
	public StudentDto(int sno, String sname, String mname, int score) {
		this.sno = sno;
		this.sname = sname;
		this.mname = mname;
		this.score = score;
	}
	public StudentDto(String rank, int sno, String sname, String mname, int score) {
		this.rank = rank;
		this.sno = sno;
		this.sname = sname;
		this.mname = mname;
		this.score = score;
	}
	public StudentDto(String rank, String sname, String mname, int score) {
		this.rank = rank;
		this.sno = sno;
		this.sname = sname;
		this.mname = mname;
		this.score = score;
	}
	
	
	
	@Override
	public String toString() {		
		if( rank != null) {
			return rank+"\t"+sname+"\t"+mname+"\t"+score;
		} else {
			return sno+"\t"+sname+"\t"+mname+"\t"+score;
		}
		
	}


	
	public int getSno() {
		return sno;
	}


	public void setSno(int sno) {
		this.sno = sno;
	}


	public String getSname() {
		return sname;
	}


	public void setSname(String sname) {
		this.sname = sname;
	}


	public String getMname() {
		return mname;
	}


	public void setMname(String mname) {
		this.mname = mname;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}
	
	
	
}

