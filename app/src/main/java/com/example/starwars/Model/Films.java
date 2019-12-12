package com.example.starwars.Model;

import java.util.ArrayList;
import java.util.Date;

public class Films {
    private String title;
    private Integer episode_id;
    private String opening_crawl;
    private String director;
    private String producer;
    private Date release_date;
    private ArrayList<String> characters; //People
    private ArrayList<String> planets;
    private ArrayList<String> starships;
    private ArrayList<String> species;
    private ArrayList<String> vehicles;
    private String edited;
    private String created;
    private String url; // ID

    public Films(){}
    public Films(String title, Integer episode_id,
                 String opening_crawl, String director,
                 String producer, Date release_date,
                 ArrayList<String> characters,
                 ArrayList<String> planets,
                 ArrayList<String> starships,
                 ArrayList<String> species,
                 ArrayList<String> vehicles,
                 String edited, String created, String url) {
        this.title = title;
        this.episode_id = episode_id;
        this.opening_crawl = opening_crawl;
        this.director = director;
        this.producer = producer;
        this.release_date = release_date;
        this.characters = characters;
        this.planets = planets;
        this.starships = starships;
        this.species = species;
        this.vehicles = vehicles;
        this.edited = edited;
        this.created = created;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return
                "Title=" +title + "\n"+
                ", Episodes =" + episode_id +
                ", Opening_crawl='" + opening_crawl + '\'' +
                ", Director='" + director + '\'' +
                ", Producer='" + producer + '\'' +
                ", Release_date=" + release_date +
                ", Characters=" + characters.size() +
                ", Planets=" + planets.size() +
                ", Starships=" + starships.size() +
                ", Species=" + species.size() +
                ", Vehicles=" + vehicles.size() +
                ", Edited='" + edited + '\'' +
                ", Created='" + created + '\'' +
                ", Url='" + url + '\'' +
                '}';
    }
}
