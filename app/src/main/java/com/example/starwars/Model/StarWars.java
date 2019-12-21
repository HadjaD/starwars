package com.example.starwars.Model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface StarWars{
    @GET("people/?format=json")
    Call<PeopleResults> getAllPeople();

    @GET("people/{id}/")
    Call<People> getPeople(@Path("id") int peopleId);

    @GET("films/?format=json")
    Call<FilmResults> getAllFilms();

    @GET("films/{id}/?format=json")
    Call<Films> getFilmByID(@Path("id") int filmId);

}

