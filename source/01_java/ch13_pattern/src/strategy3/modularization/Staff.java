package strategy3.modularization;

import strategy3.interfaces.GetSalary;
import strategy3.interfaces.JobMng;

public class Staff extends Person {
	private String department;

	public Staff(String id, String name, String department) {
		super(id, name);
		this.department = department;
		setJob(new JobMng());
		setGet(new GetSalary());
	}

	@Override
	public void print() {
		System.out.println("ID: " + getId() + " 이름: " + getName() + " 부서 :" + department);

	}

}
