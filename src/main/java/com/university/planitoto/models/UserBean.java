package com.university.planitoto.models;

import org.springframework.data.mongodb.core.index.Indexed;

import java.io.Serializable;
 
public class UserBean implements Serializable{
 
	 private static final long serialVersionUID = 1L;
	 private String firstName;
	 private String lastName;
	 private String provider;
	 private String image;
	 @Indexed(unique=true)
	 private String facebookId;
	 
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}
}
