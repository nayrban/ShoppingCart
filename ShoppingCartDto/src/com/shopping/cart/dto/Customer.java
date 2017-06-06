package com.shopping.cart.dto;

public class Customer {
	private Cart cart;
	private String coupon;
	private boolean isNew;
	
	public static Customer newCustomer() {
		Customer customer = new Customer();
		customer.isNew = true;
		return customer;
	}
	
	public boolean getIsNew() {
		return isNew;
	}

	public void addItem(Product product, int qty) {
		if (cart == null) {
			cart = new Cart(this);			
		}
		cart.addItem(product, qty);
	}

	public String getCoupon() {
		return coupon;
	}

	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	public Cart getCart() {
		return cart;
	}

	@Override
	public String toString() {
		return "Customer [cart=" + cart + ", coupon=" + coupon + ", isNew="
				+ isNew + "]";
	}

	
}
