package com.shopping.cart.core.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.shopping.cart.core.services.DiscountService;
import com.shopping.cart.dto.Customer;

@Controller
@RequestMapping("/v1/customers")
public class CustomerController {

    private final DiscountService discountService;

    @Autowired
    public CustomerController(DiscountService discountService) {
        this.discountService = discountService;
    }
        
	@RequestMapping(value = "/discount", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Customer  postCardTransaction(@RequestBody Customer request) {
		return discountService.getDiscount(request);
	}
}
