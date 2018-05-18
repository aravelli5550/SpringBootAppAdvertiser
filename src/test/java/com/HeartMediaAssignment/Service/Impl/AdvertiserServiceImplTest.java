package com.HeartMediaAssignment.Service.Impl;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.HeartMediaAssignment.Entity.Advertiser;
import com.HeartMediaAssignment.Exception.AdvertiserFieldsNullException;
import com.HeartMediaAssignment.Exception.AdvertiserNotFoundException;
import com.HeartMediaAssignment.Mapper.AdvertiserMapper;


@RunWith(SpringJUnit4ClassRunner.class)
public class AdvertiserServiceImplTest {
	
	@InjectMocks
	private AdvertiserServiceImpl advertiserServiceImpl;
	
	@Mock
	private AdvertiserMapper advertiserMapper;
	
	@Test
	public void createAdvertiser_Success() {
		Advertiser ad = new Advertiser();
		Advertiser mocked = new Advertiser();
		mocked.setCompanyName("Random1");
		mocked.setCreditScore(1000);
		mocked.setName("Random");
		doNothing().when(advertiserMapper).insertAdvertiser(ad);
		advertiserServiceImpl.createAdvertiser(mocked);
		verify(advertiserMapper,times(1)).insertAdvertiser(mocked);
  	}
	
	@Test(expected = AdvertiserFieldsNullException.class)
	public void createAdvertiser_faliure() {
		Advertiser ad = new Advertiser();
		Advertiser mocked = new Advertiser();
		mocked.setCompanyName("Random1");
		mocked.setCreditScore(1000);
		mocked.setName(null);
		doNothing().when(advertiserMapper).insertAdvertiser(ad);
		advertiserServiceImpl.createAdvertiser(mocked);
		
  	}
	
	@Test
	public void getAdvertiser_Success() {
		Advertiser ad = new Advertiser();
		String name = "Random";
		Advertiser mocked = new Advertiser();
		mocked.setCompanyName("Random1");
		mocked.setCreditScore(1000);
		mocked.setName("Random");
		(when(advertiserMapper.getAdvertiser(name))).thenReturn(mocked);
		ad = advertiserServiceImpl.getAdvertiser(name);
		assertEquals(name, ad.getName());
  	}
	
	@Test(expected = AdvertiserNotFoundException.class)
	public void getAdvertiser_failure() {
		Advertiser ad = new Advertiser();
		String name = "Random";
		Advertiser mocked = new Advertiser();
		mocked.setCompanyName("Random1");
		mocked.setCreditScore(1000);
		mocked.setName("Random");
		(when(advertiserMapper.getAdvertiser(name))).thenReturn(null);
		ad = advertiserServiceImpl.getAdvertiser(name);
  	}
	
	@Test
	public void getAllAdvertiser_Success() {
		List<Advertiser> ad = new ArrayList<Advertiser> ();
		List<Advertiser> mockedList = new ArrayList<Advertiser> ();
		Advertiser mocked = new Advertiser();
		mocked.setCompanyName("Random1");
		mocked.setCreditScore(1000);
		mocked.setName("Random");
		mockedList.add(mocked);
		
		(when(advertiserMapper.getAllAdvertiser())).thenReturn(mockedList);
		ad = advertiserServiceImpl.getAllAdvertiser();
		assertEquals("Random", ad.get(0).getName());
		
  	}
	
	@Test(expected = AdvertiserNotFoundException.class)
	public void getAllAdvertiser_Failure() {
		List<Advertiser> ad = new ArrayList<Advertiser> ();
		List<Advertiser> empty = new ArrayList<Advertiser> ();
		(when(advertiserMapper.getAllAdvertiser())).thenReturn(empty);
		ad = advertiserServiceImpl.getAllAdvertiser();
		
  	}
}
