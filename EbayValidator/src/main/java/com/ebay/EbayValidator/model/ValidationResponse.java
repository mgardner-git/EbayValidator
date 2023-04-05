package com.ebay.EbayValidator.model;

import java.util.ArrayList;
import java.util.List;

public class ValidationResponse {
	private boolean isValid;
	private List<String> errorMessages; //do we need an error code or anything fancy like that?
	private List<String> normalizedSpecifics;
	
	public ValidationResponse() {
		errorMessages = new ArrayList<String>();
		normalizedSpecifics = new ArrayList<>();
	}
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	public List<String> getErrorMessages() {
		return errorMessages;
	}
	public void setErrorMessages(List<String> errorMessages) {
		this.errorMessages = errorMessages;
	}
	public List<String> getNormalizedSpecifics() {
		return normalizedSpecifics;
	}
	public void setNormalizedSpecifics(List<String> normalizedSpecifics) {
		this.normalizedSpecifics = normalizedSpecifics;
	}

	
	
	
}
