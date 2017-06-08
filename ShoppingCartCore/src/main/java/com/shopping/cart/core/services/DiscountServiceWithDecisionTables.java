package com.shopping.cart.core.services;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.cart.dto.Customer;

@Service
public class DiscountServiceWithDecisionTables {

	public KieContainer kieContainer;

	@Autowired
	public DiscountServiceWithDecisionTables(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}

	public Customer getDiscount(Customer customer) throws Exception {
		KieSession kSession = kieContainer. newKieSession("ksession-dtables");

		kSession.insert(customer);
		kSession.fireAllRules();

		kSession.dispose();

		return customer;
	}
}
