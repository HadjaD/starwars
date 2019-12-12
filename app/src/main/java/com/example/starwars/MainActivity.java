package com.example.starwars;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.starwars.Vue.OnDataSelectedActivity;

import static com.example.starwars.R.menu.menu_filter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(menu_filter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.data:
                //Toast.makeText(this, "People selected",Toast.LENGTH_SHORT).show();
                Intent onDataSelected = new Intent(this, OnDataSelectedActivity.class);
                startActivity(onDataSelected);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
