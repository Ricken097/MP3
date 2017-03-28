package com.example.harsh.mp3;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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


/**
 * A simple {@link Fragment} subclass.
 */
public class PlayerStats extends Fragment {

    String teamName;
    ListView listView;
    View rootView;
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

    public PlayerStats() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_home, container, false);


        new RetrieveFeedTask().execute();

        return rootView;
    }

    class RetrieveFeedTask extends AsyncTask<Void, Void, String> {

        private Exception exception;

        protected String doInBackground(Void... urls) {
            // Do some validation here

            try {
                URL url = new URL("http://cricapi.com/api/fantasySummary?apikey=ObGfAsu5YDeOJyNC0Lv14sOe8NA3");
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
                JSONObject data = object.getJSONObject("data");
                JSONArray team = data.getJSONArray("team");


                final List<String> listinnews = new ArrayList<String>();

                for (int i = 0; i < team.length(); i++) {
                    JSONObject p = (JSONObject) team.get(i);
                    teamName = p.getString("name");
                    listinnews.add(teamName);

                    ArrayAdapter<String> adapterNews = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, listinnews);
                    listView = (ListView) rootView.findViewById(R.id.teamlist);
                    listView.setAdapter(adapterNews);
                }

            } catch (JSONException e) {
                // Appropriate error handling code
            }
            Log.i("INFO", response);
        }
    }

}
