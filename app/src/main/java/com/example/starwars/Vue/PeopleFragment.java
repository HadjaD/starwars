package com.example.starwars.Vue;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.starwars.Adapter.DataAdapterPeople;
import com.example.starwars.Controller.PeopleDisplayHandler;
import com.example.starwars.Model.Films;
import com.example.starwars.Model.People;
import com.example.starwars.R;

import java.util.List;

public class PeopleFragment extends Fragment {
    private TabView tabViewModel;
    private PeopleDisplayHandler pdh;
    private List<People> people;
    private RecyclerView recycler;
    private DataAdapterPeople adapter;
    public PeopleFragment(){}
    public static PeopleFragment newInstance() {
        return new PeopleFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // init ViewModel
        tabViewModel = ViewModelProviders.of(requireActivity()).get(TabView.class);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //setData();
        //System.out.println(films.isEmpty());
        //View view = inflater.inflate(R.layout.film_holderview, container, false);
        //TextView tv = view.findViewById(R.id.title1);
        //tv.setText(films.get(0).getTitle());
        return inflater.inflate(R.layout.films, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("user_prefs", Context.MODE_PRIVATE);
        recycler = getView().findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler = getView().findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.setHasFixedSize(true);
        recycler.setAdapter(adapter);
        this.pdh = new PeopleDisplayHandler(this, sharedPreferences);
        pdh.start();
        this.people = pdh.getResults();
    }
    public void setData(List<People> results){
        recycler = getView().findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.setHasFixedSize(true);
        adapter = new DataAdapterPeople(pdh.getResults());
        recycler.setAdapter(adapter);
    }

}
