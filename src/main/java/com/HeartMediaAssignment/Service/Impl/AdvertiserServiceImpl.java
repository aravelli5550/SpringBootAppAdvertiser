package com.HeartMediaAssignment.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.HeartMediaAssignment.Entity.Advertiser;
import com.HeartMediaAssignment.Exception.AdvertiserFieldsNullException;
import com.HeartMediaAssignment.Exception.AdvertiserNotFoundException;
import com.HeartMediaAssignment.Exception.CannotPerformTransactionException;
import com.HeartMediaAssignment.Mapper.AdvertiserMapper;
import com.HeartMediaAssignment.Service.AdvertiserService;

@Service
public class AdvertiserServiceImpl implements AdvertiserService {
	
	private AdvertiserMapper advertiserMapper;
	private static final Integer FixedCreditLimit = 500;
	
	public AdvertiserServiceImpl(AdvertiserMapper advertiserMapper) {
		this.advertiserMapper = advertiserMapper;
	}

	@Override
	public void createAdvertiser(Advertiser advertiser) {
		if(advertiser.getCreditScore() == null || advertiser.getName() == null || advertiser.getCompanyName() == null)
		{
			throw new AdvertiserFieldsNullException();
		}
		 advertiserMapper.insertAdvertiser(advertiser);
	}

	@Override
	public Advertiser getAdvertiser(String name) {
		
		Advertiser advertiser =  advertiserMapper.getAdvertiser(name);
		if(advertiser == null) {
			throw new AdvertiserNotFoundException();
		}
		return advertiser;
	}

	@Override
	public List<Advertiser> getAllAdvertiser() {
		
		List<Advertiser> advertiserList = new ArrayList<Advertiser> ();
		advertiserList = advertiserMapper.getAllAdvertiser();
		if (advertiserList.size() == 0) {
			throw new AdvertiserNotFoundException();
		}
		return advertiserList;
	}

	@Override
	public void updateAdvertiser(String name,Advertiser advertiser) {
		Advertiser oldAdvertiser = advertiserMapper.getAdvertiser(name);
		if(oldAdvertiser== null) {
			throw new AdvertiserNotFoundException();
		}
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
		} else {
			throw new AdvertiserNotFoundException();
		}
		
	}

	@Override
	public boolean checkAdvertiserCreditStatus(String name, Integer creditScore) {
		Advertiser oldAdvertiser = advertiserMapper.getAdvertiser(name);
		Integer validateCreditScore;
		if(creditScore != null) {
			validateCreditScore = creditScore;
		} else {
			validateCreditScore = FixedCreditLimit;
		}
		if(oldAdvertiser.getCreditScore() >= validateCreditScore) {
			return true;
		} else {
			throw new CannotPerformTransactionException();
		}
		
	}
	
	

}
