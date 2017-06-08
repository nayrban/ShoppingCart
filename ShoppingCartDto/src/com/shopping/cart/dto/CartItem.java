package com.shopping.cart.dto;

import java.io.Serializable;

public class CartItem implements Serializable{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Product product;
	private int qty;

	public CartItem(){
		
	}
	
	public CartItem(Product product, int qty) {		
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

	@Override
	public String toString() {
		return "CartItem [product=" + product + ", qty=" + qty + "]";
	}
	
	
}
