package com.university.planitoto.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "user")
public class User {

    @Id
    private String id;

    private String facebookId;
    private String name;
    private List<Hike> hikes;

    public User() {

    }

    public User(String facebookId, String name, List<Hike> hikes) {
        this.facebookId = facebookId;
        this.name = name;
        this.hikes = hikes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Hike> getHikes() {
        return hikes;
    }

    public void setHikes(List<Hike> hikes) {
        this.hikes = hikes;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", facebookId='" + facebookId + '\'' +
                ", name='" + name + '\'' +
                ", hikes=" + hikes +
                '}';
    }
}
