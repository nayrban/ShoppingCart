package com.shopping.cart.dto;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private Customer customer;
	private List<CartItem> cartItems = new ArrayList<>();
	private double discount;

	public Cart(){
		
	}
	
	public Cart(Customer customer) {
		this.customer = customer;
	}

	public void addItem(Product p, int qty) {
		CartItem cartItem = new CartItem(this, p, qty);
		cartItems.add(cartItem);
	}

	public double getDiscount() {
		return discount;
	}

	public void addDiscount(double discount) {
		this.discount += discount;
	}

	public int getTotalPrice() {
		int total = 0;
		for (CartItem item : cartItems) {
			total += item.getProduct().getPrice() * item.getQty();
		}
		return total;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getFinalPrice() {
		return getTotalPrice() - (int) getDiscount();
	}

	@Override
	public String toString() {
		return "Cart [customer=" + customer + ", cartItems=" + cartItems
				+ ", discount=" + discount + "]";
	}

}
