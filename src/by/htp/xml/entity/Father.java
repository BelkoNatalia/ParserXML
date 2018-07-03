package by.htp.xml.entity;

public class Father extends Human{
	private String military;

	public Father(String name, String surname, int age, String military) {
		super(name, surname, age);
		this.military = military;
	}

	public Father() {
		// TODO Auto-generated constructor stub
	}

	public String getMilitary() {
		return military;
	}

	public void setMilitary(String military) {
		this.military = military;
	}

	@Override
	public String toString() {
		return "Father [military=" + military + ", name=" + name + ", surname=" + surname + ", age=" + age + "]";
	}
	

}
