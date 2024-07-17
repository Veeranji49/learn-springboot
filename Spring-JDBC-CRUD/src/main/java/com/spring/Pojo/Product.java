package com.spring.Pojo;

public class Product {

	private int id;
	private String name;
	private double cost;
	private String location;

	// PDC
	public Product() {
	}

	// PPC
	public Product(int id, String name, double cost, String location) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.location = location;
	}

	// PSM & PGM
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	// toString method

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", cost=" + cost + ", location=" + location + "]";
	}

}
