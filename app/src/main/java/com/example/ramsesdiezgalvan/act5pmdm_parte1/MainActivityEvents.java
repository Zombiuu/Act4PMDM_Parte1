package com.example.ramsesdiezgalvan.act5pmdm_parte1;

import android.util.Log;

import com.example.ramsesdiezgalvan.act5pmdm_parte1.asynTasks.HttpJsonListener;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by ramsesdiezgalvan on 19/1/18.
 */

public class MainActivityEvents implements HttpJsonListener {


    @Override
    public void jsonDownload(String s) {

        try {
            JSONObject jsonObject = new JSONObject(s);

            System.out.println( jsonObject.getJSONArray("countries"));


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
