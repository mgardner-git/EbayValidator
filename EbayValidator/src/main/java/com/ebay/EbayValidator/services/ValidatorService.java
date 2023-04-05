package com.ebay.EbayValidator.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebay.EbayValidator.model.Item;
import com.ebay.EbayValidator.model.ValidationResponse;

@Service
public class ValidatorService {

	//should these be in a properties file or soemthing?
	public static final int DESCRIPTION_MAX_LENGTH = 5000;
	public static final int IMAGE_URLS_MIN_IMAGES_REQUIRED = 1000;
	public static final int DESCRIPTION_MIN_PRICE_REQUIRED = 500;
	public static final int DESCRIPTION_MIN_LENGTH = 50;
	
	@Autowired
	private NormalizerService normalizer;
	
	public ValidationResponse validate(Item item) {
		ValidationResponse response = new ValidationResponse();
		//List<String> normalized = new ArrayList<>();
		//List<String> errorMessages = new ArrayList<>();
		for (String spec : item.getSpecifics()) {
			try {
				if (spec == null || spec.length() == 0) {
					response.getErrorMessages().add("Item specifics are below the minimum length of 1");
				} else {
					String normalated = normalizer.normalize(spec);
					response.getNormalizedSpecifics().add(normalated);					
				}
			} catch (InterruptedException e) {
				response.getErrorMessages().add(e.getMessage());
			}
			
		}
		
		validateSiteId(item, response);
		validateCategoryId(item, response);
		validatePrice(item, response);
		validateQuantity(item, response);
		validateDescription(item, response);
		validateImageUrls(item, response);
		
		response.setValid(response.getErrorMessages().isEmpty());
		return response;
	}
	
	private void validateSiteId(Item item, ValidationResponse response) {
		if (item.getSiteId() == null || item.getSiteId() <= 0) {
			response.getErrorMessages().add("Item site id is missing");
		}		
	}
	
	private void validateCategoryId(Item item, ValidationResponse response) {
		if (item.getCategoryId() == null || item.getCategoryId() <= 0) {
			response.getErrorMessages().add("Item category id is missing");
		}		
	}
	
	private void validatePrice(Item item, ValidationResponse response) {
		if  (item.getPrice() == null || item.getPrice() <= 0) {
			response.getErrorMessages().add("Item price is missing");
		}
		
	}
	
	private void validateQuantity(Item item, ValidationResponse response) {
		if (item.getQuantity() == null || item.getQuantity() <= 0) {
			response.getErrorMessages().add("Item quantity is misssing");
		}
		
	}
	
	private void validateImageUrls(Item item, ValidationResponse response) {
		if (item.getPrice() > 1000) {
			if (item.getImageUrls() == null || item.getImageUrls().isEmpty()) {
				response.getErrorMessages().add("Items with price over 1000 must have at least 1 image");
			}
		}
	}
	
	private void validateDescription(Item item, ValidationResponse response) {
		if (item.getDescription().length() > DESCRIPTION_MAX_LENGTH) {
			response.getErrorMessages().add("Item description exceeds max length of 5000");
		}
		if (item.getPrice() > DESCRIPTION_MIN_PRICE_REQUIRED) {
			if (item.getDescription() == null || item.getDescription().length() < DESCRIPTION_MIN_LENGTH) {
				response.getErrorMessages().add("items with price over " + DESCRIPTION_MIN_PRICE_REQUIRED + " must have a description with length > " + DESCRIPTION_MIN_LENGTH);
			}
		}
	}
}
