package com.HeartMediaAssignment.Exception;

public class AdvertiserNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public AdvertiserNotFoundException() {
		super("Advertisers not Found");
	}

}
