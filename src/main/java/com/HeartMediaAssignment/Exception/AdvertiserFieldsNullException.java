package com.HeartMediaAssignment.Exception;

public class AdvertiserFieldsNullException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public AdvertiserFieldsNullException() {
		super("All Advertiser fields cannot be null");
	}

}
