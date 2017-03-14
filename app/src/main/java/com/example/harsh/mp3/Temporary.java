package com.example.harsh.mp3;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
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
                URL url = new URL("https://newsapi.org/v1/articles?source=espn-cric-info&sortBy=top&apiKey=a437797d1236452c98af1204492f3a8f");
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
                JSONArray articles = object.getJSONArray("articles");


                final List<String> listinnews = new ArrayList<String>();

                for (int i = 0; i < articles.length(); i++) {
                    JSONObject p = (JSONObject) articles.get(i);
                    title1 = p.getString("title");
                    listinnews.add(title1);

                    ArrayAdapter<String> adapterNews = new ArrayAdapter<String>(Temporary.this, android.R.layout.simple_list_item_1, listinnews);
                    data = (ListView) findViewById(R.id.data);
                    data.setAdapter(adapterNews);
                }

            } catch (JSONException e) {
                // Appropriate error handling code
            }
            Log.i("INFO", response);
        }
    }

}
