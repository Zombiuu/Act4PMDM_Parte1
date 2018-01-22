package com.example.ramsesdiezgalvan.act5pmdm_parte1;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    JSONObject jsonobject;
    JSONArray jsonarray;
    ProgressDialog mProgressDialog;
    ArrayList<String> worldlist;
    ArrayList<WorldPopulation> world;

    // Locate the textviews in activity_main.xml
    TextView txtrank;
    TextView txtcountry;
    TextView txtpopulation;

    Spinner mySpinner;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtrank = findViewById(R.id.rank);
        txtcountry = findViewById(R.id.country);
        txtpopulation = findViewById(R.id.population);
        mySpinner = findViewById(R.id.my_spinner);
        // Download JSON file AsyncTask
        new DownloadJSON().execute();

    }

    // Download JSON file AsyncTask
    private class DownloadJSON extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            // Locate the WorldPopulation Class
            world = new ArrayList<WorldPopulation>();
            // Create an array to populate the spinner
            worldlist = new ArrayList<String>();
            // JSON file URL address
            jsonobject = JSONfunctions
                    .getJSONfromURL("http://www.androidbegin.com/tutorial/jsonparsetutorial.txt");

            try {
                // Locate the NodeList name
                jsonarray = jsonobject.getJSONArray("worldpopulation");
                for (int i = 0; i < jsonarray.length(); i++) {
                    jsonobject = jsonarray.getJSONObject(i);

                    WorldPopulation worldpop = new WorldPopulation();

                    worldpop.setRank(jsonobject.optString("rank"));
                    worldpop.setCountry(jsonobject.optString("country"));
                    worldpop.setPopulation(jsonobject.optString("population"));
                    worldpop.setFlag(jsonobject.optString("flag"));
                    world.add(worldpop);

                    // Populate spinner with country names
                    worldlist.add(jsonobject.optString("country"));

                }
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void args) {



            // Spinner adapter
            mySpinner
                    .setAdapter(new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_spinner_dropdown_item,
                            worldlist));

            // Spinner on item click listener
            mySpinner
                    .setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                        @SuppressLint("SetTextI18n")
                        @Override
                        public void onItemSelected(AdapterView<?> arg0,
                                                   View arg1, int position, long arg3) {
                            // TODO Auto-generated method stub

                            // Set the text followed by the position
                            txtrank.setText("Rank : "
                                    + world.get(position).getRank());
                            txtcountry.setText("Country : "
                                    + world.get(position).getCountry());
                            txtpopulation.setText("Population : "
                                    + world.get(position).getPopulation());
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> arg0) {
                            // TODO Auto-generated method stub
                        }
                    });
        }
    }

}
