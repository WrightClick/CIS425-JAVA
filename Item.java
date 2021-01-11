package edu.buffalostate.cis425.fa19.exercises.wright;

public class Item {
	
	private String name;
	private double cost;
	private int quantity;
	
	
	//Constructors--------------------------------
	public Item() {
		this.name = "";
		this.cost = 0;
		this.quantity = 0;
	}
	
	public Item(String name, double cost) {
		this.name = name;
		this.cost = cost;
	}
	
	public Item(String name, double cost, int quantity) {
		this.name = name;
		this.cost = cost;
		this.quantity = quantity;
	}
	
	
	//.get methods--------------------------------
	public String getName() {
		return this.name;
	}
	
	public double getCost() {
		return this.cost;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	
	//.set methods--------------------------------
	public void setName(String name) {
		this.name = name;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}
	
}
