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
    private String YouTubeVideo;

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
                "\nTitle:        " +title + "\n"+
                        "-----------------------------------------------------------------------------------\n"+
                "Episodes :    " + episode_id +"\n"+
                        "-----------------------------------------------------------------------------------\n"+
                "Opening_crawl : " + opening_crawl  +"\n"+
                        "-----------------------------------------------------------------------------------\n"+
                "Director     : " +director  +"\n"+
                        "-----------------------------------------------------------------------------------\n"+
                "Producer :    " + producer  +"\n"+
                        "-----------------------------------------------------------------------------------\n"+
                "Release_date : " + release_date +"\n"+
                        "-----------------------------------------------------------------------------------\n"+
                "Characters :  " + characters.size() +"\n"+
                        "-----------------------------------------------------------------------------------\n"+
                "Planets :     " + planets.size() +"\n"+
                        "-----------------------------------------------------------------------------------\n"+
                "Starships :   " + starships.size() +"\n"+
                        "-----------------------------------------------------------------------------------\n"+
                "Species :     " + species.size() +"\n"+
                        "-----------------------------------------------------------------------------------\n"+
                "Vehicles :    " + vehicles.size() +"\n"+
                        "-----------------------------------------------------------------------------------\n"+
                "Edited on :   " + edited  +"\n"+
                        "-----------------------------------------------------------------------------------\n"+
                "Created on :  " + created  +"\n"+
                        "-----------------------------------------------------------------------------------\n"+
                "Url :         " + url + "\n";
    }
    public void setYouTubeVideo(String YouTubeVideo){
        this.YouTubeVideo = YouTubeVideo;
    }

    public String getYouTubeUrl() {
        return this.YouTubeVideo;
    }
}
