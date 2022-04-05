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
	// �̷��� �ϰ�  �������̵��ؼ� super.print()  �ϰ� �߰��� ��, ����,�μ� �־��൵��

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
