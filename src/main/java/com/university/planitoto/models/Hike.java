package com.university.planitoto.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Document(collection="hikes")
public class Hike {

    @Id
    private String id;

    private String name;
    private String region;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    private String route;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    private String cabin;
    private String owner;
//    private List<UserBean> users;
    
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

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
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

//	public List<UserBean> getUsers() {
//		return users;
//	}
//
//	public void setUsers(List<UserBean> users) {
//		this.users = users;
//	}

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
