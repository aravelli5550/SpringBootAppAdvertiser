package com.HeartMediaAssignment.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.HeartMediaAssignment.Entity.Advertiser;
import com.HeartMediaAssignment.Service.AdvertiserService;

@RestController
@RequestMapping("/api")
public class AdvertiserController {
	
	private AdvertiserService advertiserService;

	@Autowired
	public AdvertiserController(AdvertiserService advertiserService) {
		this.advertiserService = advertiserService;
	}
	
	@RequestMapping(value = "/advertiser", method = RequestMethod.POST)
	public void createAdvertiser(@RequestBody Advertiser advertiser) {
		 advertiserService.createAdvertiser(advertiser);
	}
	
	@RequestMapping(value = "/advertiser/{name}", method = RequestMethod.GET)
	public Advertiser getAdvertiser(@PathVariable String name) {
		Advertiser advertiser = advertiserService.getAdvertiser(name);
		return advertiser;
	}
	
	@RequestMapping(value = "/advertiser", method = RequestMethod.GET)
	public List<Advertiser> getAllAdvertiser() {
		return advertiserService.getAllAdvertiser();
	}
	
	@RequestMapping(value = "/advertiser/{name}", method = RequestMethod.PUT)
	public void updateAdvertiser(@PathVariable String name,@RequestBody Advertiser advertiser) {
		 advertiserService.updateAdvertiser(name, advertiser);
	}
	
	@RequestMapping(value = "/advertiser/{name}", method = RequestMethod.DELETE)
	public void deleteAdvertiser(@PathVariable String name) {
		 advertiserService.deleteAdvertiser(name);
	}
	
	@RequestMapping(value = "/advertiser/checkAdvertiserCreditStatus/{name}", method = RequestMethod.GET)
	public boolean checkAdvertiserCreditStatus(@PathVariable String name,@RequestParam("creditScore") Integer creditScore) {
		 return advertiserService.checkAdvertiserCreditStatus(name,creditScore);
	}
	
	
	
}
