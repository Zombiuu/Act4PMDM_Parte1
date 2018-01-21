package com.example.ramsesdiezgalvan.act5pmdm_parte1.asynTasks;

import android.os.AsyncTask;

/**
 * Created by ramsesdiezgalvan on 18/1/18.
 */


/*
 Primero parametro : primer metodo, es el que recibe los datos.
 Segundo parametro : segundo metodo, el metodo de espera
 Tercer parametro : tercer metodo, es el que va a devolver
 */


public class HttpAsynTask extends AsyncTask<String,Integer,Void> {




    public HttpAsynTask(){

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    //metodo que recibe los datos
    @Override
    protected Void doInBackground(String... strings) {



        return null;
    }

    //metodo de espera
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }



    //metodo de salida
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
}
