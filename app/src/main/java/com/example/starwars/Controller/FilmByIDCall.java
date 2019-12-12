package com.example.starwars.Controller;

import android.util.Log;

import com.example.starwars.Model.Films;
import com.example.starwars.Model.SWHttpClient;
import com.example.starwars.Vue.FilmsActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmByIDCall implements Callback<Films> {
    private int Id;
    private FilmsActivity fa;

    public FilmByIDCall(int id, FilmsActivity fa) {
        Id = id;
        this.fa = fa;
    }

    public void start(){
        Log.d("TAG    >>>","CALLING");
        Call<Films> films = SWHttpClient.get().getFilmByID(this.Id);
        Log.v("TAG    >>>","END CALLING");
        films.enqueue(this);
    }
    @Override
    public void onResponse(Call<Films> call, Response<Films> response) {
        if (response.isSuccessful()){
            Films film = response.body();
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
