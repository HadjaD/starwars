package com.example.starwars.Model;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface StarWars{
    @GET("people/?format=json")
    Call<PeopleResults> getAllPeople();
    /*public void getAllPeople(@Query("page") int page,
                             Callback<ListEndPointsSW<People>> callback);*/

    @GET("people/{id}/")
    Call<People> getPeople(@Path("id") int peopleId);

    @GET("films/?format=json")
    Call<FilmResults> getAllFilms();
    /*public void getAllFilms(@Query("page") int page,
                            Callback<ListEndPointsSW<Films>> callback);*/

    @GET("films/{id}/?format=json")
    Call<Films> getFilmByID(@Path("id") int filmId);

}

