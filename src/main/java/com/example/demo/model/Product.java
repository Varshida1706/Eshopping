package com.example.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "Product")
public class Product {
	private int ID;
	private String Name;
	private int Price;
	
	public Product(int ID,String Name,int Price)
	{
		this.ID=ID;
		this.Name=Name;
		this.Price=Price;
	}

	@Override
	public String toString() {
		return "Product [ID=" + ID + ", Name=" + Name + ", Price=" + Price + "]";
	}
 
	public String getName()
	{
		return Name;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public void setName(String name) {
		Name = name;
	}
	
}
