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
import com.HeartMediaAssignment.Exception.CannotPerformTransactionException;
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
	
	@Test
	public void updateAdvertiser() {
		
		Advertiser ad = new Advertiser();
		ad.setCompanyName("RandomUpdate");
		ad.setCreditScore(1000);
		ad.setName("Random");
		
		Advertiser mocked = new Advertiser();
		mocked.setCompanyName("Random1");
		mocked.setCreditScore(1000);
		mocked.setName("Random");
		
		String name = "Random";
		(when(advertiserMapper.getAdvertiser(name))).thenReturn(mocked);
		doNothing().when(advertiserMapper).updateAdvertiser(ad);
		advertiserServiceImpl.updateAdvertiser(name, ad);
		verify(advertiserMapper,times(1)).updateAdvertiser(ad);
		
  	}
	
	@Test(expected = AdvertiserNotFoundException.class)
	public void updateAdvertiser_Failure() {
		
		Advertiser ad = new Advertiser();
		ad.setCompanyName("RandomUpdate");
		ad.setCreditScore(1000);
		ad.setName("Random");
		
		String name = "Random";
		(when(advertiserMapper.getAdvertiser(name))).thenReturn(null);
		advertiserServiceImpl.updateAdvertiser(name, ad);
		
		
  	}
	
	@Test
	public void updateAdvertiser_whenCompanyNameisNull() {
		
		Advertiser ad = new Advertiser();
		ad.setCompanyName(null);
		ad.setCreditScore(1000);
		ad.setName("Random");
		
		Advertiser mocked = new Advertiser();
		mocked.setCompanyName("Random1");
		mocked.setCreditScore(1000);
		mocked.setName("Random");
		
		String name = "Random";
		(when(advertiserMapper.getAdvertiser(name))).thenReturn(mocked);
		advertiserServiceImpl.updateAdvertiser(name, ad);
		verify(advertiserMapper,times(1)).updateAdvertiser(ad);
		
  	}
	
	@Test
	public void updateAdvertiser_whenCreditLimitisNull() {
		
		Advertiser ad = new Advertiser();
		ad.setCompanyName("RandomUpdate");
		ad.setCreditScore(null);
		ad.setName("Random");
		
		Advertiser mocked = new Advertiser();
		mocked.setCompanyName("Random1");
		mocked.setCreditScore(1000);
		mocked.setName("Random");
		
		String name = "Random";
		(when(advertiserMapper.getAdvertiser(name))).thenReturn(mocked);
		advertiserServiceImpl.updateAdvertiser(name, ad);
		verify(advertiserMapper,times(1)).updateAdvertiser(ad);
		
  	}
	
	@Test
	public void deleteAdvertiser_Success() {
		
		Advertiser mocked = new Advertiser();
		mocked.setCompanyName("Random1");
		mocked.setCreditScore(1000);
		mocked.setName("Random");
		
		String name = "Random";
		(when(advertiserMapper.getAdvertiser(name))).thenReturn(mocked);
		doNothing().when(advertiserMapper).deleteAdvertiser(name);
		advertiserServiceImpl.deleteAdvertiser(name);
		verify(advertiserMapper,times(1)).deleteAdvertiser(name);
		
		
  	}
	
	@Test(expected = AdvertiserNotFoundException.class)
	public void deleteAdvertiser_Failure() {
		
		Advertiser mocked = new Advertiser();
		mocked.setCompanyName("Random1");
		mocked.setCreditScore(1000);
		mocked.setName("Random");
		
		String name = "Random";
		(when(advertiserMapper.getAdvertiser(name))).thenReturn(null);
		advertiserServiceImpl.deleteAdvertiser(name);
		
		
  	}
	
	@Test
	public void checkAdvertiserCreditStatus_Success() {
		
		Advertiser mocked = new Advertiser();
		mocked.setCompanyName("Random1");
		mocked.setCreditScore(1000);
		mocked.setName("Random");
		
		String name = "Random";
		Integer creditLimit = 900;
		(when(advertiserMapper.getAdvertiser(name))).thenReturn(mocked);
		
		boolean status = advertiserServiceImpl.checkAdvertiserCreditStatus(name, creditLimit);
		
		assertEquals(true, status);
		
		
  	}
	
	@Test(expected = CannotPerformTransactionException.class)
	public void checkAdvertiserCreditStatus_Failure() {
		
		Advertiser mocked = new Advertiser();
		mocked.setCompanyName("Random1");
		mocked.setCreditScore(1000);
		mocked.setName("Random");
		
		String name = "Random";
		Integer creditLimit = 1200;
		(when(advertiserMapper.getAdvertiser(name))).thenReturn(mocked);
		
		advertiserServiceImpl.checkAdvertiserCreditStatus(name, creditLimit);
		
  	}
	
}
