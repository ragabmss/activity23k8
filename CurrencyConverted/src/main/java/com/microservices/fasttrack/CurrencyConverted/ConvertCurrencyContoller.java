package com.microservices.fasttrack.CurrencyConverted;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConvertCurrencyContoller {
    
	@Autowired
	private FeignClientProxy feignProxy;
	
	@GetMapping("/convertcurrency/{code}/{amount}")
	public double convertCurrency(@PathVariable String code, @PathVariable double amount) {
		return amount* (feignProxy.getConversionFactor(code));	
	}
	
	
}
