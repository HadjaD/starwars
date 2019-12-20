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
    private final String[] yUrl ={"MpkrMqmmy5k", "Vf90oa4G-w4", "bD7bpG-zDJQ", "5UnjrG_N8hU", "5UfA_aKBGMc", "JNwNXF9Y6kY", "sGbxmsDFVnE"}; //YouTube Video URL;
    public TitleDisplayHandler(FilmFragment ff){
        this.filmFragment = ff;
    }

    public TitleDisplayHandler(){}

    public void start(){
        Call<FilmResults> films = SWHttpClient.get().getAllFilms();
        films.enqueue(this);
    }

    @Override
    public void onResponse(Call<FilmResults> call, Response<FilmResults> response) {
        if(response.isSuccessful()) {
            FilmResults list = response.body();
            this.results = list.getResults();
            setUrl(this.results);
            Log.v("TAG    >>>>>>>","Response Success >>>>>>"+this.results.size());
            this.filmFragment.setData(this.results);
        }else{
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
    public void setUrl(List<Films> films){
        for(int i = 0; i<yUrl.length; i++) films.get(i).setYouTubeVideo(yUrl[i]);
    }
}
