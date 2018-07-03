package by.htp.xml.entity;

public class Mother extends Human{
	private String maidenName;

	
	public Mother(String name, String surname, int age, String maidenName) {
		super(name, surname, age);
		this.maidenName = maidenName;
	}
	
	public Mother() {
		// TODO Auto-generated constructor stub
	}
	
	public String getMaidenName() {
		return maidenName;
	}
	 
	public void setMaidenName(String maidenName) {
		this.maidenName = maidenName;
	}

	@Override
	public String toString() {
		
		return "Mother [maidenName=" + maidenName + ", name=" + name + ", surname=" + surname + ", age=" + age + "]";
	}
	
	
}
