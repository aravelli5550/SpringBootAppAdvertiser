package com.HeartMediaAssignment.Controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.http.MediaType;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.HeartMediaAssignment.Entity.Advertiser;
import com.HeartMediaAssignment.Service.AdvertiserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

@RunWith(SpringJUnit4ClassRunner.class)
public class AdvertiserControllerTest {
	
	@InjectMocks
	private AdvertiserController advertiserController;
	
	@Mock
	private AdvertiserService advertiserService;
	
	private MockMvc mvc;
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
		this.mvc = MockMvcBuilders.standaloneSetup(advertiserController).build();
	}
	
	@Test
	public void createAdvertiser() throws Exception {
		 MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
		 
		 Advertiser mocked = new Advertiser();
		 mocked.setCompanyName("Random1");
		 mocked.setCreditScore(1000);
		 mocked.setName("Random");
		 
		 ObjectMapper mapper = new ObjectMapper();
		    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		    ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		    String requestJson=ow.writeValueAsString(mocked);
		    
		    doNothing().when(advertiserService).createAdvertiser(mocked);
		    
		    mvc.perform(post("/api/advertiser").accept(MediaType.APPLICATION_JSON)
					.contentType(APPLICATION_JSON_UTF8)
		            .content(requestJson))
		    		.andExpect(status().isOk());
		 
	}
	
	@Test
	public void getAdvertiser() throws Exception {
		 MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
		 Advertiser mocked = new Advertiser();
		 mocked.setCompanyName("Random1");
		 mocked.setCreditScore(1000);
		 mocked.setName("nike");	
		
		String name = "nike";
		(when(advertiserService.getAdvertiser(name))).thenReturn(mocked);
		    
		 mvc.perform( get("/api/advertiser/nike")
					.contentType(APPLICATION_JSON_UTF8))
					.andExpect(status().isOk());	
		 
	}
	
	@Test
	public void getAllAdvertiser() throws Exception {
		 MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
		 Advertiser mocked = new Advertiser();
		 mocked.setCompanyName("Random1");
		 mocked.setCreditScore(1000);
		 mocked.setName("nike");
		 List<Advertiser> mockedList = new ArrayList<Advertiser> ();
		 mockedList.add(mocked);
		
		(when(advertiserService.getAllAdvertiser())).thenReturn(mockedList);
		    
		 mvc.perform( get("/api/advertiser")
					.contentType(APPLICATION_JSON_UTF8))
					.andExpect(status().isOk());	
		 
	}
	
	@Test
	public void updateAdvertiser() throws Exception {
		MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
		 
		 Advertiser mocked = new Advertiser();
		 mocked.setCompanyName("Random1");
		 mocked.setCreditScore(1000);
		 mocked.setName("Random");
		 
		 Advertiser input = new Advertiser();
		 input.setCompanyName("Random2");
		 
		 
		 ObjectMapper mapper = new ObjectMapper();
		    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		    ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		    String requestJson=ow.writeValueAsString(mocked);
		    
		    String name = "Random";
		    
			doNothing().when(advertiserService).updateAdvertiser(name , input);
		    
		 mvc.perform( put("/api/advertiser/Random")
					 .contentType(APPLICATION_JSON_UTF8)
					 .content(requestJson))
					 .andExpect(status().isOk());	
		 
	}
	
	@Test
	public void deleteAdvertiser() throws Exception {
		MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
		 
		 Advertiser mocked = new Advertiser();
		 mocked.setCompanyName("Random1");
		 mocked.setCreditScore(1000);
		 mocked.setName("Random");
		 
		 Advertiser input = new Advertiser();
		 input.setCompanyName("Random2");
		 
		 
		 ObjectMapper mapper = new ObjectMapper();
		    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		    ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		    String requestJson=ow.writeValueAsString(mocked);
		    
		    String name = "Random";
		    
			doNothing().when(advertiserService).deleteAdvertiser(name);
		    
		 mvc.perform( delete("/api/advertiser/Random")
					 .contentType(APPLICATION_JSON_UTF8)
					 .content(requestJson))
					 .andExpect(status().isOk());	
		 
	}
	
	@Test
	public void  checkAdvertiserCreditStatus() throws Exception {
		 MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
		 
		
		String name = "nike";
		Integer creditScore = 900;
		(when(advertiserService.checkAdvertiserCreditStatus(name,creditScore))).thenReturn(false);
		    
		 mvc.perform( get("/api/advertiser/checkAdvertiserCreditStatus/nike?creditScore=900")
					.contentType(APPLICATION_JSON_UTF8))
					.andExpect(status().isOk());	
		 
	}
	
	
	
	
	
}
