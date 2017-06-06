package com.shopping.cart.dto;

import java.util.ArrayList;
import java.util.List;

public class Cart {	
	private List<CartItem> cartItems = new ArrayList<>();
	private double discount;

	public Cart(){
	}
	
	public void addItem(Product p, int qty) {
		CartItem cartItem = new CartItem(p, qty);
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

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public int getFinalPrice() {
		return getTotalPrice() - (int) getDiscount();
	}

	@Override
	public String toString() {
		return "Cart [cartItems=" + cartItems + ", discount=" + discount + "]";
	}

}
