class Person {

	String name;
	int age;
	
	Person(){
		this("이름없음",1);     // Person(String,int)  생성자 호출
	}
	Person(String name, int age){
		this.name = name;
		this.age = age;
		
	}
	Person returnItSelf() {
		return this;    // 주소를 반환하는 것
		
	}
	public class CallAnotherConst {
		public void main(String[] args) { 
			
		Person noName = new Person();
		System.out.println(noName.name);
		System.out.println(noName.age);
		
		Person p = noName.returnItSelf();
		System.out.println(p);
		System.out.println(noName);
	}
}
}
	
	
	