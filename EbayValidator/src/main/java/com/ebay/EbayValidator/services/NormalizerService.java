package com.ebay.EbayValidator.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class NormalizerService {

	public String normalize(String itemSpecific) throws InterruptedException {
		String result = String.valueOf(itemSpecific.charAt(0)).toUpperCase() + itemSpecific.substring(1).toLowerCase();
		Thread.sleep(1000);
		return result;
		
	}
}
