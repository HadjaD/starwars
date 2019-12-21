package com.example.starwars.Controller;

import android.content.SharedPreferences;
import android.util.Log;

import com.example.starwars.Model.Films;
import com.example.starwars.Model.SWHttpClient;
import com.example.starwars.Vue.FilmActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmByIDCall implements Callback<Films> {
    private String Id;
    private FilmActivity fa;
    private SharedPreferences sp;
    private Films film = new Films();
    //private ConstantURL cUrl = new ConstantURL();

    public FilmByIDCall(String id, FilmActivity fa, SharedPreferences sp) {
        Id = id;
        this.fa = fa;
        this.sp = sp;
    }

    public void start(){
        Log.d("TAG    >>>","CALLING  "+this.Id);
        Call<Films> films = SWHttpClient.get().getFilmByID(Integer.parseInt(this.Id)+1);
        Log.v("TAG    >>>","END CALLING");
        films.enqueue(this);
    }
    @Override
    public void onResponse(Call<Films> call, Response<Films> response) {
        if (response.isSuccessful()){
            this.film = response.body();
            fa.displayData(film);
        }else{
            Log.d("TAG    >>>","Error   "+response.raw().request().url());
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<Films> call, Throwable t) {
        Log.d("TAG    >>>","Error   "+t.getMessage());

    }

}
