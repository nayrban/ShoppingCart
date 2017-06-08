package com.shopping.cart.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.cart.dto.Customer;
import com.shopping.cart.rules.api.RulesServiceExecutor;

@Service
public class DiscountServiceRestApi {

	private RulesServiceExecutor ruleServicesClient;	

	@Autowired
	public DiscountServiceRestApi(RulesServiceExecutor ruleServicesClient) {
		this.ruleServicesClient = ruleServicesClient;
	}

	public Customer getDiscount(Customer customer) {
		customer = ruleServicesClient.executeRule(customer);
		
		return customer;
	}
}
