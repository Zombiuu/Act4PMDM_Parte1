package com.example.ramsesdiezgalvan.act5pmdm_parte1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ramsesdiezgalvan.act5pmdm_parte1.asynTasks.HttpJson;

public class MainActivity extends AppCompatActivity{
    MainActivityEvents events;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        events = new MainActivityEvents();

        HttpJson httpJson = new HttpJson();

        httpJson.setListener(events);

        String url = "http://api.population.io:80/1.0/countries";

        httpJson.execute(url);




    }


}
