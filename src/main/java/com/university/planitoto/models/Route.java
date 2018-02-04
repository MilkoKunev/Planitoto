package com.university.planitoto.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Document(collection="routes")

public class Route {

    @Id
    private String id;

    private String description;
    private String name;
    private String region;
    private List<String> hikes;
    private String image;
    public Route(){}

    public Route(String description, String name, String region, List<String> hikes) {
        this.description = description;
        this.name = name;
        this.region = region;
        this.hikes = hikes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getHikes() {
        return hikes;
    }

    public void setHikes(List<String> hikes) {
        this.hikes = hikes;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Route{" +
                "name='" + name + '\'' +
                ", description=" + description + '\'' +
                ", region=" + region + '\'' +
                ", hikes=" + hikes + '\'' +
                '}';
    }
}
