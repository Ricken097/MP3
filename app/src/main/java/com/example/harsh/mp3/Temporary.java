package com.example.harsh.mp3;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Temporary extends AppCompatActivity {
    ListView data;
    String title1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temporary);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        new RetrieveFeedTask().execute();

    }

    class RetrieveFeedTask extends AsyncTask<Void, Void, String> {

        private Exception exception;

        protected String doInBackground(Void... urls) {
            // Do some validation here

            try {
                URL url = new URL("https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20cricket.player.profile%20where%20player_id%3D2962&format=json&diagnostics=true&env=store%3A%2F%2F0TxIGQMQbObzvU4Apia0V0&callback=");
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");
                    }
                    bufferedReader.close();
                    return stringBuilder.toString();
                } finally {
                    urlConnection.disconnect();
                }
            } catch (Exception e) {
                Log.e("ERROR", e.getMessage(), e);
                return null;
            }
        }

        protected void onPostExecute(String response) {
            if (response == null) {
                response = "THERE WAS AN ERROR";
            }
            try {
                JSONObject object = (JSONObject) new JSONTokener(response).nextValue();
                JSONObject query = object.getJSONObject("query");
                title1 = query.getString("created");
                System.out.println("IN TEMPORARY COUNT========" + title1);

                //JSONObject results = query.getJSONObject("results");
                //JSONArray player = results.getJSONArray("PlayerProfile");


                final List<String> listinnews = new ArrayList<String>();

                //for (int i = 0; i < player.length(); i++) {
                //  JSONObject p = (JSONObject) player.get(i);
                //title1 = p.getString("personid");
                //listinnews.add(title1);

                //ArrayAdapter<String> adapterNews = new ArrayAdapter<String>(Temporary.this, android.R.layout.simple_list_item_1, listinnews);
                //data = (ListView) findViewById(R.id.data);
                //data.setAdapter(adapterNews);
                // }

            } catch (JSONException e) {
                // Appropriate error handling code
            }
            Log.i("INFO", response);
        }
    }

}
