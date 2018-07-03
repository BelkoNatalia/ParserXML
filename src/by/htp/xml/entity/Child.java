package by.htp.xml.entity;

public class Child extends Human {

	public Child(String name, String surname, int age) {
		super(name, surname, age);
	}

	public Child() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Child [name=" + name + ", surname=" + surname + ", age=" + age + "]";
	}
}
