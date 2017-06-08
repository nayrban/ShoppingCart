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
import com.shopping.cart.core.services.DiscountServiceRestApi;
import com.shopping.cart.core.services.DiscountServiceWithDecisionTables;
import com.shopping.cart.dto.Customer;

@Controller
@RequestMapping("/v1/customers")
public class CustomerController {

	private DiscountService discountService;
    private DiscountServiceWithDecisionTables discountServiceXLS;
    private DiscountServiceRestApi discountServiceRestApi; 

    @Autowired
    public CustomerController(DiscountService discountService, DiscountServiceWithDecisionTables discountServiceXLS,
    		DiscountServiceRestApi discountServiceRestApi) {
        this.discountService = discountService;
        this.discountServiceXLS = discountServiceXLS;
        this.discountServiceRestApi = discountServiceRestApi;
    }
        
	@RequestMapping(value = "/discount", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Customer  postCardTransaction(@RequestBody Customer request) {
		return discountService.getDiscount(request);
	}
	
	
	@RequestMapping(value = "/discountxls", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Customer  postCardTransactionXLS(@RequestBody Customer request) {
		try {
			request = discountServiceXLS.getDiscount(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return request;
	}
	
	@RequestMapping(value = "/discountapi", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Customer  postCardTransactionRestApi(@RequestBody Customer request) {
		try {
			request = discountServiceRestApi.getDiscount(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return request;
	}
		
}
