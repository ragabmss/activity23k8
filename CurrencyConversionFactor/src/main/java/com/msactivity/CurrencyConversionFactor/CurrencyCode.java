package com.msactivity.CurrencyConversionFactor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="currcode")
public class CurrencyCode {
    
	@Id
	@Column(name="code")
	private String code;
	@Column(name="cfactor")
	private double cfactor;
	
	public CurrencyCode() {
		
	}
	
	public CurrencyCode(String code, double cfactor) {
		super();
		this.code = code;
		this.cfactor = cfactor;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public double getCfactor() {
		return cfactor;
	}
	public void setCfactor(double cfactor) {
		this.cfactor = cfactor;
	}
	
	
	
}
