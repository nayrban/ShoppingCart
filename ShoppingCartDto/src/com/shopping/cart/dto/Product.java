package com.shopping.cart.dto;

public class Product {
	private int price;
	private String desc;
	
	public Product(){
		
	}
	
	public Product(String desc, int price) {
		this.desc = desc;
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public String getDesc() {
		return desc;
	}

	public String toString() {
		return "Product [price=" + price + ", desc=" + desc + "]";
	}
}
