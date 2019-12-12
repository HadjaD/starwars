package com.example.starwars.Controller;
import android.util.Log;

import com.example.starwars.Model.FilmResults;
import com.example.starwars.Model.Films;
import com.example.starwars.Model.SWHttpClient;
import com.example.starwars.Vue.FilmFragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TitleDisplayHandler implements Callback<FilmResults>{
    private List<Films> results = new ArrayList<>();
    private FilmFragment filmFragment;
    public TitleDisplayHandler(FilmFragment ff){
        this.filmFragment = ff;
    }

    public TitleDisplayHandler(){}

    public void start(){
        Log.d("TAG    >>>","CALLING");
        Call<FilmResults> films = SWHttpClient.get().getAllFilms();
        Log.v("TAG    >>>","END CALLING");
        films.enqueue(this);
    }

    @Override
    public void onResponse(Call<FilmResults> call, Response<FilmResults> response) {
        if(response.isSuccessful()) {
            FilmResults list = response.body();
            this.results = list.getResults();
            Log.v("TAG    >>>>>>>","Response Success >>>>>>"+this.results.size());
            this.filmFragment.setData(this.results);
        }else{
            Log.v("TAG    >>>","Response Error");
            System.out.println(response.raw().request().url());

        }

    }

    @Override
    public void onFailure(Call<FilmResults> call, Throwable t) {
        Log.v("TAG    >>>","Response failure >>>"+t.getMessage());
    }
    public List<Films> getResults(){
        return this.results;
    }
}
