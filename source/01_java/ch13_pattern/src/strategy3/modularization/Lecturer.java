package strategy3.modularization;

import strategy3.interfaces.GetSalary;
import strategy3.interfaces.JobLec;

public class Lecturer extends Person {
	private String subject;
	
	public Lecturer(String id, String name, String subject) {
		super(id,name);
		this.subject = subject;
		setJob(new JobLec());
		setGet(new GetSalary());
	}
	
	
	@Override
	public void print() {
		System.out.println("ID: "+getId()+" 이름: "+getName()+" 과목 :"+ subject);
		
	}
	

}
