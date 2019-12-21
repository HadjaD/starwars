package com.example.starwars.Vue;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import android.widget.Toast;

import com.example.starwars.Controller.FilmByIDCall;
import com.example.starwars.Model.Films;
import com.example.starwars.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;
public class FilmActivity extends YouTubeBaseActivity implements
        YouTubePlayer.OnInitializedListener {
    private YouTubePlayer YPlayer;
    private FilmByIDCall call;
    private TextView content;
    String url = "";
    private  final String YoutubeDeveloperKey = "AIzaSyBrbUPiHfdczqFG85JZ-ckIqTaauhDaRdE";//getString(R.string.apikey);
    private static final int RECOVERY_DIALOG_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.film);
        Intent activ = getIntent();
        String donnee = activ.getStringExtra("film");
        this.url = activ.getStringExtra("url");
        SharedPreferences sharedPreferences = this.getSharedPreferences("user_prefs", Context.MODE_PRIVATE);
        this.call = new FilmByIDCall(donnee, this, sharedPreferences);
        this.call.start();
        YouTubePlayerView youTubeView = findViewById(R.id.youtube_view);
        youTubeView.initialize(YoutubeDeveloperKey, this);

    }
    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                        YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show();
        } else {
            String errorMessage = String.format(
                    "There was an error initializing the YouTubePlayer",
                    errorReason.toString());
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_DIALOG_REQUEST) {
            // Retry initialization if user performed a recovery action
            getYouTubePlayerProvider().initialize(YoutubeDeveloperKey, this);
        }
    }
    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return (YouTubePlayerView) findViewById(R.id.youtube_view);
    }
    @Override
    public void onInitializationSuccess(Provider provider,
                                        YouTubePlayer player, boolean wasRestored) {
        YPlayer = player;
        /*
         * Now that this variable YPlayer is global you can access it
         * throughout the activity, and perform all the player actions like
         * play, pause and seeking to a position by code.
         */
        if (!wasRestored) {
            YPlayer.cueVideo(url);
        }
    }
    public void displayData(Films film){
        content = findViewById(R.id.content);
        content.setText(film.toString());
        content.setMovementMethod(new ScrollingMovementMethod());

    }
}