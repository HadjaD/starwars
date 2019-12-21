package com.example.starwars.Vue;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.starwars.Controller.PeopleByIDCall;
import com.example.starwars.Model.People;
import com.example.starwars.R;

public class PeopleActivity extends AppCompatActivity {
    private TextView name;
    private TextView birth;
    private TextView eye;
    private TextView mass;
    private TextView height;
    private TextView gender;
    private TextView skin;
    private TextView hair;
    private TextView films;
    private TextView vehicles;
    private TextView species;
    private TextView edited;
    private TextView url;
    private TextView starships;
    private PeopleByIDCall call;
    private String donnee;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.people);
        Intent activ = getIntent();
        String donnee = activ.getStringExtra("people");
        SharedPreferences sharedPreferences = this.getSharedPreferences("user_prefs", Context.MODE_PRIVATE);
        this.call = new PeopleByIDCall(donnee, this, sharedPreferences);
        this.call.start();


    }
    public void setDonnee(String name){
        this.donnee = name;
    }
    public void displayData(People people){
        this.name = findViewById(R.id.name);
        this.birth = findViewById(R.id.birth);
        this.eye = findViewById(R.id.eye);
        this.mass = findViewById(R.id.mass);
        this.height = findViewById(R.id.height);
        this.gender = findViewById(R.id.gender);
        this.skin = findViewById(R.id.skin);
        this.hair = findViewById(R.id.hair);
        this.films = findViewById(R.id.films);
        this.vehicles = findViewById(R.id.vehicles);
        this.species = findViewById(R.id.species);
        this.starships = findViewById(R.id.starships);
        this.edited = findViewById(R.id.edited);
        this.url = findViewById(R.id.url);
        name.setText("Title    : "+people.getName());
        birth.setText("Birth Year    : "+people.getBirth_year());
        eye.setText("Eye Color   : "+people.getEye_color());
        mass.setText("Mass    : "+people.getMass());
        height.setText("Height    : "+people.getHeight());
        gender.setText("Gender   : "+people.getGender());
        skin.setText("Skin Color    : "+people.getSkin_color());
        hair.setText("Hair Color    : "+people.getHair_color());
        vehicles.setText("Total Vehicles   : "+people.getVehicles());
        species.setText("Total Species    : "+people.getSpecies());
        starships.setText("Total Starships    : "+people.getStarships());
        films.setText("Total Films    : "+people.getFilms());
        edited.setText("Edited on    : "+people.getEdited());
        url.setText("Url    : : "+people.getUrl());


    }
}
