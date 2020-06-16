	package com.ss.houserecommendation.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class House 
{
	private final UUID id;
	private final String name;
	private final String imageUrl;
	private final String location;
	private final String description;
	private final String price;
	
	
	
	public House(@JsonProperty("id") UUID id,@JsonProperty("name") String name,
			@JsonProperty("imageUrl")String imageUrl,@JsonProperty("location") String location, @JsonProperty("description")String description, 
			@JsonProperty("price")String price)
	{
		this.id = id;
		this.name = name;
		this.imageUrl = imageUrl;
		this.location = location;
		this.description = description;
		this.price = price;
	}
	
	public UUID getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public String getLocation() {
		return location;
	}
	public String getDescription() {
		return description;
	}
	public String getPrice() {
		return price;
	}
	
	

}
