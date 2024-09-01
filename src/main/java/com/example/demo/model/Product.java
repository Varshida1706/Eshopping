package com.example.demo.model;


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
	
}
