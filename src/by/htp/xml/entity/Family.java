package by.htp.xml.entity;

import java.util.ArrayList;

public class Family {
	private int id;
	private Father father;
	private Mother mother;
	private ArrayList<Child> childs;

	public Family() {}
	
	public Family(Father father, Mother mother, ArrayList<Child> childs, int id) {
		this.id = id;
		this.father = father;
		this.mother = mother;
		this.childs = childs;
	}

	public Father getFather() {
		return father;
	}

	public void setFather(Father father) {
		this.father = father;
	}

	public Mother getMother() {
		return mother;
	}

	public void setMother(Mother mother) {
		this.mother = mother;
	}

	public ArrayList<Child> getChilds() {
		return childs;
	}

	public void setChilds(ArrayList<Child> childs) {
		this.childs = childs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Family [id=" + id + ", father=" + father + ", mother=" + mother + ", childs=" + childs + "]";
	}

	
}
