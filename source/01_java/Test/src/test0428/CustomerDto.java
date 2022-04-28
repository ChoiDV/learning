package test0428;

public class CustomerDto {
	private String phone;
	private String name;
	private int point;
	
	public CustomerDto() {}

	public CustomerDto(String phone, String name, int point) {		
		this.phone = phone;
		this.name = name;
		this.point = point;
	}
	
	@Override
	public String toString() {
		return phone+"\t\t"+name+"\t"+point+" Á¡";		
	}

	public String getPhone() {
		return phone;
	}

	public String getName() {
		return name;
	}

	public int getPoint() {
		return point;
	}
		
}
