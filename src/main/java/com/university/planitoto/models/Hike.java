package com.university.planitoto.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="hikes")
public class Hike {
	
    @Id
    private String id;

    private String name;
    private String region;
    private String startDate;
    private String route;
    private String endDate;
    private String cabin;
    private String owner;
    
    public Hike() {}

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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getCabin() {
		return cabin;
	}

	public void setCabin(String cabin) {
		this.cabin = cabin;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
    
    @Override
    public String toString() {
        return "Hike{" +
                "name='" + name + '\'' +
                
                ", region=" + region + '\'' +
                ", startDate=" + startDate + '\'' +
                ", endDate=" + endDate + '\'' +
                ", route=" + route + '\'' +                
                ", cabin=" + cabin + '\'' +   
                ", owner=" + owner + '\'' +                 
                '}';
    }
    

}
