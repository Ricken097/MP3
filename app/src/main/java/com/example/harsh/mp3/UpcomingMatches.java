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
public class UpcomingMatches extends Fragment {


    ListView data;
    String team1, team2, date, team, uid;
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    View rootView;
    public UpcomingMatches() {
        // Required empty public constructor
    }

    void writeNewMatches(String uid1, String team11, String team21, String date1, String team111) {
        UpcomingMatchesDB umdb = new UpcomingMatchesDB(uid1, team11, team21, date1);
        mDatabase.child("cricit").child("Upcoming Matches").child(team111).setValue(umdb);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        rootView = inflater.inflate(R.layout.fragment_upcoming_matches, container, false);

        new RetrieveFeedTask().execute();

        return rootView;
    }

    class RetrieveFeedTask extends AsyncTask<Void, Void, String> {

        private Exception exception;

        protected String doInBackground(Void... urls) {
            // Do some validation here

            try {
                URL url = new URL("http://cricapi.com/api/matches/?apikey=ObGfAsu5YDeOJyNC0Lv14sOe8NA3");
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
                JSONArray matches = object.getJSONArray("matches");


                final List<String> listinMatches = new ArrayList<String>();


                for (int i = 0; i < matches.length(); i++) {
                    JSONObject p = (JSONObject) matches.get(i);
                    team1 = p.getString("team-1");
                    team2 = p.getString("team-2");
                    date = p.getString("date");
                    uid = p.getString("unique_id");


                    team = team1 + " Vs " + team2;
                    writeNewMatches(uid, team1, team2, date, team);
                    System.out.println("IN LOOP COUNT========" + team);
                    System.out.println("IN LOOP COUNT========" + date);

                    listinMatches.add(team);

                    ArrayAdapter<String> adapterMatches = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, listinMatches);


                    data = (ListView) rootView.findViewById(R.id.data);
                    data.setAdapter(adapterMatches);
                }

            } catch (JSONException e) {
                // Appropriate error handling code
            }
            Log.i("INFO", response);
        }
    }

}
