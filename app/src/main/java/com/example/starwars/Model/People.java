package com.example.starwars.Model;

import java.util.ArrayList;
import java.util.List;

public class People {
    private String name;
    private String height;
    private String mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String homeworld; //planet
    private ArrayList<String> films;
    private ArrayList<String> species;
    private ArrayList<String> vehicles;
    private ArrayList<String> starships;
    private String edited;
    private String created;
    private String url; // ID
    private String id;

    public People(String name, String height,
                  String mass, String hair_color,
                  String skin_color, String eye_color,
                  String birth_year, String gender,
                  String homeworld, ArrayList<String> films,
                  ArrayList<String> species,
                  ArrayList<String> vehicles,
                  ArrayList<String> starships, String edited,
                  String created, String url) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.hair_color = hair_color;
        this.skin_color = skin_color;
        this.eye_color = eye_color;
        this.birth_year = birth_year;
        this.gender = gender;
        this.homeworld = homeworld;
        this.films = films;
        this.species = species;
        this.vehicles = vehicles;
        this.starships = starships;
        this.edited = edited;
        this.created = created;
        this.url = url;
        this.setID();
    }
    public People(){}
    public String getName() {
        return name;
    }
    public void setID(){
        String url [] = this.url.split("/");
        this.id = url[url.length-1];
    }

    public String getHeight() {
        return height;
    }

    public String getMass() {
        return mass;
    }

    public String getHair_color() {
        return hair_color;
    }

    public String getSkin_color() {
        return skin_color;
    }

    public String getEye_color() {
        return eye_color;
    }

    public String getBirth_year() {
        return birth_year;
    }

    public String getGender() {
        return gender;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public Integer getFilms() {
        return films.size();
    }

    public Integer getSpecies() {
        return species.size();
    }

    public Integer getVehicles() {
        return vehicles.size();
    }

    public Integer getStarships() {
        return starships.size();
    }

    public String getEdited() {
        return edited;
    }

    public String getCreated() {
        return created;
    }

    public String getUrl() {
        return url;
    }

    public String getId() {
        return id;
    }
}
