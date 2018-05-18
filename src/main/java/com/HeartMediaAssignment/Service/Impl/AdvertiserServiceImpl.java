package com.HeartMediaAssignment.Service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.HeartMediaAssignment.Entity.Advertiser;
import com.HeartMediaAssignment.Mapper.AdvertiserMapper;
import com.HeartMediaAssignment.Service.AdvertiserService;

@Service
public class AdvertiserServiceImpl implements AdvertiserService {
	
	private AdvertiserMapper advertiserMapper;
	
	public AdvertiserServiceImpl(AdvertiserMapper advertiserMapper) {
		this.advertiserMapper = advertiserMapper;
	}

	@Override
	public void createAdvertiser(Advertiser advertiser) {
		 advertiserMapper.insertAdvertiser(advertiser);
	}

	@Override
	public Advertiser getAdvertiser(String name) {
		return advertiserMapper.getAdvertiser(name);
	}

	@Override
	public List<Advertiser> getAllAdvertiser() {
		return advertiserMapper.getAllAdvertiser();
	}

	@Override
	public void updateAdvertiser(String name,Advertiser advertiser) {
		Advertiser oldAdvertiser = advertiserMapper.getAdvertiser(name);
		advertiser.setName(oldAdvertiser.getName());
		if(advertiser.getCreditScore() != null && advertiser.getCompanyName() != null) {
			//do nothing
		} else if(advertiser.getCreditScore() == null && advertiser.getCompanyName() != null) {
			advertiser.setCreditScore(oldAdvertiser.getCreditScore());
			
		} else if(advertiser.getCreditScore() != null && advertiser.getCompanyName() == null) {
			advertiser.setCompanyName(oldAdvertiser.getCompanyName());
		}
		advertiserMapper.updateAdvertiser(advertiser);
	}

	@Override
	public void deleteAdvertiser(String name) {
		Advertiser oldAdvertiser = advertiserMapper.getAdvertiser(name);
		if(oldAdvertiser != null) {
			advertiserMapper.deleteAdvertiser(name);
		}
		
	}

	@Override
	public boolean checkAdvertiserCreditStatus(String name, Integer creditScore) {
		Advertiser oldAdvertiser = advertiserMapper.getAdvertiser(name);
		if(oldAdvertiser.getCreditScore() >= creditScore) {
			return true;
		}
		return false;
	}
	
	

}
