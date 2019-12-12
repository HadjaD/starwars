package com.example.starwars.Vue;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.starwars.Adapter.DataAdapter;
import com.example.starwars.Controller.TitleDisplayHandler;
import com.example.starwars.Model.Films;
import com.example.starwars.R;

import java.util.List;

public class FilmFragment extends Fragment {
    private TabView tabViewModel;
    private TitleDisplayHandler tdh;
    private List<Films> films;
    private RecyclerView recycler;
    private DataAdapter adapter;
    public FilmFragment(){}
    public static FilmFragment newInstance() {
        return new FilmFragment();
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
        recycler = getView().findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler = getView().findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.setHasFixedSize(true);
        recycler.setAdapter(adapter);
        this.tdh = new TitleDisplayHandler(this);
        tdh.start();
        this.films = tdh.getResults();
    }
    public void setData(List<Films> results){
        recycler = getView().findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.setHasFixedSize(true);
        adapter = new DataAdapter(tdh.getResults());
        recycler.setAdapter(adapter);
    }

}
