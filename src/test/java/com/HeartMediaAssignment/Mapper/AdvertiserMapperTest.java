package com.HeartMediaAssignment.Mapper;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.HeartMediaAssignment.IHeartMediaAssignmentApplication;
import com.HeartMediaAssignment.Entity.Advertiser;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = IHeartMediaAssignmentApplication.class)
public class AdvertiserMapperTest {
	
	@Autowired
	private AdvertiserMapper advertiserMapper;
	
	
	
	@Test
	public void insertAdvertiser() {
		Advertiser advertiser =  new Advertiser();
		advertiser.setCompanyName("RandomCompanyName");
		advertiser.setName("Random");
		advertiser.setCreditScore(1000);
		advertiserMapper.insertAdvertiser(advertiser);
		advertiserMapper.deleteAdvertiser("Random");
		
	}
	
	@Test
	public void getAdvertiserAndDelete_Success_ByName() {
		Advertiser advertiser =  new Advertiser();
		advertiser.setCompanyName("RandomCompanyName");
		advertiser.setName("Random1");
		advertiser.setCreditScore(1000);
		advertiserMapper.insertAdvertiser(advertiser);
		Advertiser advertiserResponse = advertiserMapper.getAdvertiser(advertiser.getName());
		assertEquals("Random1", advertiserResponse.getName());
		advertiserMapper.deleteAdvertiser("Random1");
	}
	
	@Test
	public void getAllAdvertiserAndDelete_Success() {
		Advertiser advertiser =  new Advertiser();
		advertiser.setCompanyName("RandomCompanyName");
		advertiser.setName("Random1");
		advertiser.setCreditScore(1000);
		advertiserMapper.insertAdvertiser(advertiser);
		List<Advertiser> advertiserResponse = advertiserMapper.getAllAdvertiser();
		assertEquals(1, advertiserResponse.size());
		advertiserMapper.deleteAdvertiser("Random1");
	}
	
	

	@Test
	public void updateAdvertiser_Success_ByName() {
		Advertiser advertiser =  new Advertiser();
		advertiser.setCompanyName("RandomCompanyNames");
		advertiser.setName("Random1");
		advertiser.setCreditScore(1000);
		advertiserMapper.updateAdvertiser(advertiser);
		advertiserMapper.deleteAdvertiser("Random1");
	}


}
