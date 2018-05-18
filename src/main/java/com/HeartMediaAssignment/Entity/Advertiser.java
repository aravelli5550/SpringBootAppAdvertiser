package com.HeartMediaAssignment.Entity;

import java.io.Serializable;

public class Advertiser implements Serializable{
	private static final long serialVersionUID = 9161820206767558501L;
	
	private String name;
	private String companyName;
	private Integer creditScore;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Integer getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(Integer creditScore) {
		this.creditScore = creditScore;
	}
	
	@Override
	public String toString() {
		return "Advertiser [name=" + name + ", companyName=" + companyName + ", creditScore=" + creditScore + "]";
	}
	
	
	
	

}
