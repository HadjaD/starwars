package com.example.starwars.Controller;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

import com.example.starwars.Model.People;
import com.example.starwars.Model.SWHttpClient;
import com.example.starwars.Vue.PeopleActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PeopleByIDCall implements Callback<People> {
    private String Id;
    private PeopleActivity pa;
    private SharedPreferences sharedPreferences;

    public PeopleByIDCall(String id, PeopleActivity fa, SharedPreferences prefs) {
        this.Id = id;
        this.pa = fa;
        this.sharedPreferences = prefs;
    }

    public void start(){
        //Log.d("TAG    >>>","CALLING");
        Log.d("TAG    >>>","PARSED ID >>>>>"+this.Id);
        //Integer id = Integer.parseInt(this.Id);

        Call<People> people = SWHttpClient.get().getPeople(Integer.parseInt(this.Id)+1);
        Log.v("TAG    >>>","END CALLING");
        people.enqueue(this);
    }
    @Override
    public void onResponse(Call<People> call, Response<People> response) {
        if (response.isSuccessful()){
            People people = response.body();
            storeData(people);
            pa.displayData(people);
        }else{
            Log.d("TAG    >>>","Error   "+response.raw().request().url());
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<People> call, Throwable t) {
        Log.d("TAG    >>>","Error   "+t.getMessage());

    }
    private void storeData(People people) {
        Gson gson = new Gson();
        String data = gson.toJson(people);
        sharedPreferences
                .edit()
                .putString("cle_string" + this.Id, data)
                .apply();
    }

    private People getDataFromCache() {
        String people = sharedPreferences.getString("cle_string"  + this.Id, "");
        if(people != null && !TextUtils.isEmpty(people)){
            Type listType = new TypeToken<People>(){}.getType();
            People character = new Gson().fromJson(people, listType);
            return character;
        }
        return new People();
    }
}
