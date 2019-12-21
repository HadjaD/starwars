package com.example.starwars.Adapter;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.starwars.Model.Films;
import com.example.starwars.R;
import com.example.starwars.Vue.FilmActivity;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Films> films;
    public DataAdapter(List<Films> films) {
        this.films = films;
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
            final Films film = this.films.get(position);
            dataHolder.title.setText(film.getTitle());
        }

    }

    @Override
    public int getItemCount() {
        return this.films.size();
    }
    public void addItem(int position, Films film){
        this.films.add(position, film);

    }
    public void removeItem(int position){
        this.films.remove(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public Films getItem(int position){
        return this.films.get(position);
    }
    public class DataHolder extends RecyclerView.ViewHolder{
        TextView title;
        ImageView icon;
        View layout;
        String url = "";
        public DataHolder(View itemView){
            super(itemView);
            layout = itemView;
            title = layout.findViewById(R.id.title);
            icon = layout.findViewById(R.id.view);
            icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), FilmActivity.class);
                    String[] data = getFilmPosition((String)title.getText());
                    intent.putExtra("film",data[0]);
                    intent.putExtra("url", data[1]);
                    Log.d("TAG    >>>",intent.getStringExtra("film"));
                    v.getContext().startActivity(intent);
                }
            });

        }
    }
    public String[] getFilmPosition(String title){
        String [] data = new String[2];
        for(int i = 0; i<this.films.size(); i++){
            if(this.films.get(i).getTitle().equals(title)){
                data[0] = Integer.toString(i);
                data[1] = this.films.get(i).getYouTubeUrl();
                break;
            }
        }
        return data;
    }

}
