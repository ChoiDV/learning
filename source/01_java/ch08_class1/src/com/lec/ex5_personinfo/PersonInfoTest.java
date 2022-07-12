package com.lec.ex5_personinfo;

public class PersonInfoTest {

	public static void main(String[] args) {
		
		PersonInfo choi = new PersonInfo("최진영",24,"남자");
		choi.print();	
		PersonInfo[] person2 = {choi};
		
		PersonInfo[] person = {new PersonInfo("오동준",28,"남"),
							   new PersonInfo("홍길동",26,"여")};
		for(int idx = 0; idx <person.length; idx++) {
			person[idx].print();
		}
		for(PersonInfo p : person) {
			p.print();
		}
				
		}
		
		

	}


