package com.example.starwars.Vue;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.starwars.Controller.FilmByIDCall;
import com.example.starwars.Model.Films;
import com.example.starwars.R;

public class FilmsActivity extends AppCompatActivity {
    private TextView content;
    private VideoView video;
    private FilmByIDCall call;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.film);
        this.call = new FilmByIDCall(1, this);
        this.call.start();


    }
    public void displayData(Films film){
        content = (TextView)findViewById(R.id.content);
        content.setText(film.toString());
        content.setMovementMethod(new ScrollingMovementMethod());
        video = (VideoView)findViewById(R.id.video_view);

        MediaController m = new MediaController(this);
        video.setMediaController(m);
        Uri uri = Uri.parse("https://www.youtube.com/watch?v=PgHYbSfEGkU/");
        Toast t = Toast.makeText(this, "URL = >>>>"+uri.toString(),Toast.LENGTH_LONG);
        t.show();
        video.setVideoURI(uri);

        video.start();



    }
}
