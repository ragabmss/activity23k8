package com.microservices.fasttrack.CurrencyConverted;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
//@FeignClient(name="currency-conversion-factor", url = "localhost:8010")
//@FeignClient(name="currency-conversion-factor")
@FeignClient(name = "currency-conversion-factor", url = "${CURRENCY_EXCHANGE_URI:http://localhost}:8010")
public interface FeignClientProxy {

	@GetMapping("/country/{code}")
	public double getConversionFactor(
			@PathVariable String code) ;
	
	
}
