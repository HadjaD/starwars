package com.example.starwars.Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SWHttpClient {
    private static StarWars SwAPI_CLIENT;
    private static final String API_URL = "https://swapi.co/api/";

    static {
        loadClient();
    }

    public static StarWars get() {
        return SwAPI_CLIENT;
    }


    private static void loadClient() {

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .build();
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient)
                .build();
        SwAPI_CLIENT = retrofit.create(StarWars.class);
    }
}
