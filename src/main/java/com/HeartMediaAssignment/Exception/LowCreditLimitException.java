package com.HeartMediaAssignment.Exception;

public class LowCreditLimitException extends RuntimeException{
	
private static final long serialVersionUID = 1L;
	
	public LowCreditLimitException() {
		super("Advertiser has low CreditLimit");
	}

}
