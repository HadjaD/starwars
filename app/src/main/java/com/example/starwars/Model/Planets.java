package com.example.starwars.Model;

import java.util.ArrayList;

public class Planets {
    private String name;
    private String rotation_period;
    private String orbital_period;
    private String diameter;
    private String climate;
    private String gravity;
    private String terrain;
    private String surface_water;
    private String population;
    private ArrayList<String> residents;
    private String edited;
    private String created;
    private String url; // ID

    public Planets(String name, String rotation_period,
                   String orbital_period, String diameter,
                   String climate, String gravity,
                   String terrain, String surface_water,
                   String population, ArrayList<String> residents,
                   String edited, String created, String url) {
        this.name = name;
        this.rotation_period = rotation_period;
        this.orbital_period = orbital_period;
        this.diameter = diameter;
        this.climate = climate;
        this.gravity = gravity;
        this.terrain = terrain;
        this.surface_water = surface_water;
        this.population = population;
        this.residents = residents;
        this.edited = edited;
        this.created = created;
        this.url = url;
    }
}
