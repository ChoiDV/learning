package com.lec.ex5_personinfo;

public class PersonInfoTest {

	public static void main(String[] args) {
		
		PersonInfo choi = new PersonInfo("������",24,"����");
		choi.print();	
		PersonInfo[] person2 = {choi};
		
		PersonInfo[] person = {new PersonInfo("������",28,"��"),
							   new PersonInfo("ȫ�浿",26,"��")};
		for(int idx = 0; idx <person.length; idx++) {
			person[idx].print();
		}
		for(PersonInfo p : person) {
			p.print();
		}
				
		}
		
		

	}


