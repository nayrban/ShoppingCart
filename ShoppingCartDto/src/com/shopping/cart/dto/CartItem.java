package com.shopping.cart.dto;

public class CartItem {
	private Cart cart;
	private Product product;
	private int qty;

	public CartItem(){
		
	}
	
	public CartItem(Cart cart, Product product, int qty) {
		this.cart = cart;
		this.product = product;
		this.qty = qty;
	}

	public Product getProduct() {
		return product;
	}

	public int getQty() {
		return qty;
	}	

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String toString() {
		return "CartItem [cart=" + cart + ", product=" + product + ", qty="
				+ qty + "]";
	}
}
