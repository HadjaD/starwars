package com.example.starwars.Controller;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

import com.example.starwars.Model.People;
import com.example.starwars.Model.PeopleResults;
import com.example.starwars.Model.SWHttpClient;
import com.example.starwars.Vue.PeopleFragment;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PeopleDisplayHandler implements Callback<PeopleResults>{
    private List<People> results = new ArrayList<>();
    private PeopleFragment peopleFragment;
    private SharedPreferences sharedPreferences;
    public PeopleDisplayHandler(PeopleFragment ff, SharedPreferences sharedPreferences) {
        this.peopleFragment = ff;
        this.sharedPreferences = sharedPreferences;
    }

    public PeopleDisplayHandler(){}

    public void start(){
        Log.d("TAG    >>>","CALLING");
        Call<PeopleResults> people = SWHttpClient.get().getAllPeople();
        Log.v("TAG    >>>","END CALLING");
        people.enqueue(this);
    }

    @Override
    public void onResponse(Call<PeopleResults> call, Response<PeopleResults> response) {
        if(response.isSuccessful()) {
            PeopleResults list = response.body();
            this.results = list.getResults();
            Log.v("TAG    >>>>>>>","Response Success >>>>>>"+this.results.size());
            this.peopleFragment.setData(this.results);
        }else{
            Log.v("TAG    >>>","Response Error");
            System.out.println(response.raw().request().url());

        }

    }

    @Override
    public void onFailure(Call<PeopleResults> call, Throwable t) {
        Log.v("TAG    >>>","Response failure >>>"+t.getMessage());
    }
    public List<People> getResults(){
        return this.results;
    }

    private void storeData(List<People> people) {
        Gson gson = new Gson();
        String data = gson.toJson(people);
        sharedPreferences
                .edit()
                .putString("cle_string", data)
                .apply();
    }

    private List<People> getDataFromCache() {
        String data = sharedPreferences.getString("cle_string", "");
        if (data != null && !TextUtils.isEmpty(data)) {
            Type listType = new TypeToken<PeopleResults>() {
            }.getType();
            List<People> people = new Gson().fromJson(data, listType);
            return people;
        }
        return new ArrayList<>();
    }
}
