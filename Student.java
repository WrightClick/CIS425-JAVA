package edu.buffalostate.cis425.fa19.assignments.wright;
/**
 * @author Matt Wright
 * --------------------------------------------------
 * This class serves as a parent class to CIS425_Student
 */
public class Student {
	protected String id;
	protected String name;

	//Default constructor
	public Student() {
		this.id = "";
		this.name = "";
	}
	
	//Constructor with params
	public Student(String id, String name) {
		this.setName(name);
		this.setID(id);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setID(String id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getID() {
		return this.id;
	}
}
