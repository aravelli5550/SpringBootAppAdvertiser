package com.HeartMediaAssignment.Exception;

public class CannotPerformTransactionException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public CannotPerformTransactionException() {
		super("Below CreditLimit Cannot Perform Transactions");
	}
}
