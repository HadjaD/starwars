package com.example.starwars.Model;

import java.io.Serializable;
import java.util.List;

public class FilmResults implements Serializable {
    private List<Films> results;

    public List<Films> getResults(){
        return results;
    }
}
