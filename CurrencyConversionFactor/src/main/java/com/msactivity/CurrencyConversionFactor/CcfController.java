package com.msactivity.CurrencyConversionFactor;

import java.util.Optional;
import java.lang.Throwable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.retry.annotation.Retry;
//import reactor.core.publisher.Mono;

@RestController
public class CcfController{
	
	@Autowired
	private CurrJpaRepo currRepo;
	
	@Autowired
	private Environment environment;
	
	//@Autowired
	//private CurrJpaPostRepo postRepo;
	
	@GetMapping("/country/{code}")
	//@Retry(name="default", fallbackMethod="Testfallback")
	public double getConversionFactor(
			@PathVariable String code) {
		//return new CurrencyExchange(1000L, from, to, 
		//				BigDecimal.valueOf(50));
		Optional<CurrencyCode> currencyCode = Optional.ofNullable(currRepo.findByCode(code));
		
        String port = environment.getProperty("local.server.port");
		
		//CHANGE-KUBERNETES
		String host = environment.getProperty("HOSTNAME");
		String version = "v11";
		
//		currencyCode.setEnvironment(port + " " + version + " " + host);
		
		if (currencyCode.isPresent()) {
		    return currencyCode.get().getCfactor();
	    } 
		else {
			return 0;
		}
	}
	
	//public String Testfallback(CallNotPermittedException ex) {
	//	return "fallback on retry";
	//}
	
	
	
	@PostMapping("/country")
	public ResponseEntity<Object>  addConversionFactor(
			@RequestBody CurrencyCode post) {
		
		try {
			CurrencyCode currencyCode1 = currRepo.save(post);
			return new ResponseEntity(new ResponseStatus("201","success"), HttpStatus.CREATED);

		    } catch (Exception e) {
		      return new ResponseEntity<>(new ResponseStatus("501", "Internal Server Error"), HttpStatus.INTERNAL_SERVER_ERROR);
		    } 	
	}
	
	@PutMapping("/country/{code}")
	public ResponseEntity<Object>  updateConversionFactor(
			@PathVariable String code, @RequestBody CurrencyCode post) {
		CurrencyCode currencyCode = currRepo.findByCode(code);
		
		if(currencyCode ==null) {
			//throw new RuntimeException
			//	("Unable to Find data for country code " + code);
			return new ResponseEntity(new ResponseStatus("404","Country code not found"), HttpStatus.CREATED);

		}else {
			CurrencyCode currencyCode1 = currRepo.save(post);
	        return new ResponseEntity(new ResponseStatus("201","success"), HttpStatus.CREATED);
		}
	}
	
	
}
