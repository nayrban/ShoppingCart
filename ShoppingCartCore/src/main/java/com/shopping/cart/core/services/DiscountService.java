package com.shopping.cart.core.services;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.ObjectFilter;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.cart.dto.Customer;

@Service
public class DiscountService {

	private KieContainer kieContainer;

	@Autowired
	public DiscountService(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}

	public Customer getDiscount(Customer customer) {
		KieSession kieSession = kieContainer
				.newKieSession("ksession-shopping-cart");
		kieSession.insert(customer);
		kieSession.fireAllRules();
		// Customer customer2 = getDiscount(kieSession);
		kieSession.dispose();
		return customer;
	}

	@SuppressWarnings("unused")
	private Customer getDiscount(KieSession kieSession) {

		// Find all BusPass facts and 1st generation child classes of BusPass.
		ObjectFilter busPassFilter = new ObjectFilter() {
			@Override
			public boolean accept(Object object) {
				if (Customer.class.equals(object.getClass()))
					return true;
				if (Customer.class.equals(object.getClass().getSuperclass()))
					return true;
				return false;
			}
		};

		// printFactsMessage(kieSession);

		List<Customer> facts = new ArrayList<>();
		for (FactHandle handle : kieSession.getFactHandles(busPassFilter)) {
			facts.add((Customer) kieSession.getObject(handle));
		}
		if (facts.size() == 0) {
			return null;
		}
		// Assumes that the rules will always be generating a single bus pass.
		return facts.get(0);
	}
}
