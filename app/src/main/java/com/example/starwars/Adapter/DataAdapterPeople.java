package com.example.starwars.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.starwars.Model.People;
import com.example.starwars.R;
import com.example.starwars.Vue.PeopleActivity;

import java.util.List;

public class DataAdapterPeople extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<People> people;
    private Context context;
    public DataAdapterPeople(List<People> people) {
        this.people = people;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.filmview, parent, false);
        return new DataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof DataHolder){
            final DataHolder dataHolder = (DataHolder)holder;
            final People people = this.people.get(position);
            dataHolder.title.setText(people.getName());
        }

    }

    @Override
    public int getItemCount() {
        return this.people.size();
    }
    public void addItem(int position, People people){
        this.people.add(position, people);

    }
    public void removeItem(int position){
        this.people.remove(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public People getItem(int position){
        return this.people.get(position);
    }
    public class DataHolder extends RecyclerView.ViewHolder{
        TextView title;
        ImageView icon;
        View layout;
        public DataHolder(View itemView){
            super(itemView);
            layout = itemView;
            title = layout.findViewById(R.id.title);
            icon = layout.findViewById(R.id.view);
            icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), PeopleActivity.class);
                    intent.putExtra("people",getPeoplePosition((String)title.getText()));
                    v.getContext().startActivity(intent);
                }
            });

        }
    }
    public String getPeoplePosition(String name){
        String data = "";
        for(int i = 0; i<this.people.size(); i++){
            if(this.people.get(i).getName().equals(name)){
                data = Integer.toString(i);
                break;
            }
        }
        return data;
    }
}

