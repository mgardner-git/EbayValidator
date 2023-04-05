package com.ebay.EbayValidator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ebay.EbayValidator.model.Item;
import com.ebay.EbayValidator.model.ValidationResponse;
import com.ebay.EbayValidator.services.ValidatorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ValidationController {

	@Autowired
	ValidatorService validatorService;
	
	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	
	@GetMapping("/validate")
	@ResponseBody
	public ValidationResponse validate(@RequestParam String item) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		Item itemObj = mapper.readValue(item, Item.class);
		ValidationResponse response = validatorService.validate(itemObj);  
		//do we need to change the http response code if it's invalid?
		return response;
	}

}