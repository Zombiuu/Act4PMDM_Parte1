package com.example.ramsesdiezgalvan.act5pmdm_parte1;

import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.ramsesdiezgalvan.act5pmdm_parte1.asynTasks.HttpJsonListener;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by ramsesdiezgalvan on 19/1/18.
 */

public class MainActivityEvents implements HttpJsonListener {
    MainActivity mainActivity;



    public MainActivityEvents(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }

    @Override
    public void jsonDownload(String s) {

        try {
            JSONObject jsonObject = new JSONObject(s);

//

          //  System.out.println( jsonObject.getJSONArray("countries"));


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
