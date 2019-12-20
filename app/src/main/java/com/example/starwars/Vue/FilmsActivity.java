package com.example.starwars.Vue;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.starwars.Controller.FilmByIDCall;
import com.example.starwars.R;

public class FilmsActivity extends AppCompatActivity {
    private TextView content;
    private VideoView video;
    private FilmByIDCall call;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.film);
        //this.call = new FilmByIDCall("", this);
        //this.call.start();


    }
    /*public void displayData(Films film){
        content = (TextView)findViewById(R.id.content);
        content.setText(film.toString());
        content.setMovementMethod(new ScrollingMovementMethod());
        video = (VideoView)findViewById(R.id.video_view);

        MediaController m = new MediaController(this);
        video.setMediaController(m);
        video.requestFocus();
        Uri uri = Uri.parse("https://www.youtube.com/watch?v=PgHYbSfEGkU/");
        Toast t = Toast.makeText(this, "URL = >>>>"+uri.toString(),Toast.LENGTH_LONG);
        t.show();
        video.setVideoURI(uri);

        video.start();



    }*/
}
