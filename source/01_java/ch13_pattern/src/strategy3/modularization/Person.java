package strategy3.modularization;

import strategy3.interfaces.IGet;
import strategy3.interfaces.IJob;

public abstract class Person {
	private String name;
	private String id;
	private IJob job;
	private IGet get;

	public Person(String id, String name) {
		this.id = id;
		this.name = name;

	}

	public void job() {
		job.job();
	}

	public void get() {
		get.get();
	}

	public abstract void print();
	
	// public void print(){
	//  System.out.println("[id]"+id+"\t[name]"+name);
	// 이렇게 하고  오버라이드해서 super.print()  하고 추가로 반, 과목,부서 넣어줘도됨

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public void setJob(IJob job) {
		this.job = job;
	}

	public void setGet(IGet get) {
		this.get = get;
	}

}
