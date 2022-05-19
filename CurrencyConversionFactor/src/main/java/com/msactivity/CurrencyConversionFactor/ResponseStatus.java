package com.msactivity.CurrencyConversionFactor;

public class ResponseStatus {

	private String statuscode;
	private String errormessage;
	
	public ResponseStatus() {
		
	}
	
	
	public ResponseStatus(String statuscode, String errormessage) {
		super();
		this.statuscode = statuscode;
		this.errormessage = errormessage;
	}


	public String getStatusCode() {
		return statuscode;
	}
	public void setStatusCode(String statuscode) {
		this.statuscode = statuscode;
	}
	public String getErrormessage() {
		return errormessage;
	}
	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}
	
	
	
}