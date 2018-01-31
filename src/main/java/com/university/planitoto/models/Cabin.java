package com.university.planitoto.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="cabins")
public class Cabin {
	
    @Id
	private String id;
    
	private String name;
	private String region;
	private String description;
	
	public Cabin() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String descrtiption) {
		this.description = descrtiption;
	}
	
    @Override
    public String toString() {
        return "Cabin{" +
                "name='" + name + '\'' +   
                ", region=" + region + '\'' + 
                ", description=" + description + '\'' +                 
                '}';
    }
	
	
	
}
