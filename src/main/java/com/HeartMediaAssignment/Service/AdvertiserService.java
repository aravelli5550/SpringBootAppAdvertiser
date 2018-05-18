package com.HeartMediaAssignment.Service;

import java.util.List;

import com.HeartMediaAssignment.Entity.Advertiser;

public interface AdvertiserService {
	
	void createAdvertiser(Advertiser advertiser);
	Advertiser getAdvertiser(String name);
	List<Advertiser> getAllAdvertiser();
	void updateAdvertiser(String name,Advertiser advertiser);
	void deleteAdvertiser(String name);
	boolean checkAdvertiserCreditStatus(String name, Integer creditScore);

}
