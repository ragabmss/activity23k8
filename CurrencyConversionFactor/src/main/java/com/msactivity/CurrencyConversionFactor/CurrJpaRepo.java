package com.msactivity.CurrencyConversionFactor;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msactivity.CurrencyConversionFactor.CurrencyCode;

@Repository
public interface CurrJpaRepo extends JpaRepository<CurrencyCode, String>{
    
	CurrencyCode findByCode(String code);

	/*CurrencyCode save(CurrencyCode post);*/
    
}
