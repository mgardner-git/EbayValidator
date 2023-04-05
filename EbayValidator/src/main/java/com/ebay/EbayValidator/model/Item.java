package com.ebay.EbayValidator.model;

import java.util.ArrayList;
import java.util.List;


public class Item {
	private Long siteId;
	private Long categoryId;
	private String title;
	private String condition; //should this be an enum?
	private Double price; 
	private Integer quantity;
	private List<String> imageUrls; 
	private List<String> specifics; //max 2. (Does this need to be a more complex object?)
	private String description;
	
	public Item() {
		imageUrls = new ArrayList<>();
		specifics = new ArrayList<>();
	}
	public Long getSiteId() {
		return siteId;
	}
	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public List<String> getImageUrls() {
		return imageUrls;
	}
	public void setImageUrls(List<String> imageUrls) {
		this.imageUrls = imageUrls;
	}
	public List<String> getSpecifics() {
		return specifics;
	}
	public void setSpecifics(List<String> specifics) {
		this.specifics = specifics;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
}
