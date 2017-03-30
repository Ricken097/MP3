package com.example.harsh.mp3;

import android.os.AsyncTask;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by bhaVYa on 29/03/17.
 */

public class PlayerPersonalDetails {
    static Long pid;
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    private Exception exception;

    public void sendPid(long pid) {
        PlayerPersonalDetails.pid = pid;
        new PlayerPersonalDetails1().execute();
    }

    public class PlayerPersonalDetails1 extends AsyncTask<Void, Void, String> {
        protected String doInBackground(Void... urls) {
            // Do some validation here

            try {
                URL url = new URL("http://cricapi.com/api/playerStats?pid=" + pid + "&apikey=ObGfAsu5YDeOJyNC0Lv14sOe8NA3");
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


                //String fullName = object.getString("fullName");
                String country = object.getString("country");
                String imageURL = object.getString("imageURL");
                String profile = object.getString("profile");
                String bowlingStyle = object.getString("bowlingStyle");
                String battingStyle = object.getString("battingStyle");
                //String playingRole = object.getString("playingRole");
                String majorTeams = object.getString("majorTeams");
                String currentAge = object.getString("currentAge");
                String born = object.getString("born");
                String name = object.getString("name");

                writeNewPlayer(pid, country, imageURL, profile, bowlingStyle, battingStyle, majorTeams, currentAge, born, name);


                JSONObject data = object.getJSONObject("data");
                System.out.println("FULLNAME DATA====" + data);


                JSONObject batting = data.getJSONObject("batting");

                String[] BattingsBowling = {"T20Is",
                        "ODIs",
                        "tests"
                };
                int a = BattingsBowling.length;
                for (int i = 0; i < 3; i++) {
                    JSONObject battings = batting.getJSONObject(BattingsBowling[i]);
                    if (battings.equals(null)) {
                        continue;
                    }
                    String fiftiesT20 = battings.getString("50");
                    String hundredsT20 = battings.getString("100");
                    String stumpingT20 = battings.getString("St");
                    String catchesT20 = battings.getString("Ct");
                    String sixesT20 = battings.getString("6s");
                    String foursT20 = battings.getString("4s");
                    String srT20 = battings.getString("SR");
                    String ballsT20 = battings.getString("BF");
                    String avgT20 = battings.getString("Ave");
                    String hsT20 = battings.getString("HS");
                    String runsT20 = battings.getString("Runs");
                    String notoutT20 = battings.getString("NO");
                    String inningsT20 = battings.getString("Inns");
                    String matchesT20 = battings.getString("Mat");

                    writeNewPlayerBattingT20(BattingsBowling[i], pid, fiftiesT20, hundredsT20, stumpingT20, catchesT20, sixesT20, foursT20, srT20, ballsT20, avgT20, hsT20, runsT20, notoutT20, inningsT20, matchesT20);

                }

                JSONObject bowling = data.getJSONObject("bowling");

                for (int j = 0; j < 3; j++) {
                    JSONObject bowlings = bowling.getJSONObject(BattingsBowling[j]);
                    if (bowlings.equals(null)) {
                        continue;
                    }
                    String tenWicketsT20 = bowlings.getString("10");
                    String fiveWicketsT20 = bowlings.getString("5w");
                    String fourWicketsT20 = bowlings.getString("4w");
                    String srateT20 = bowlings.getString("SR");
                    String economyT20 = bowlings.getString("Econ");
                    String avgbT20 = bowlings.getString("Ave");
                    String bbmT20 = bowlings.getString("BBM");
                    String bbiT20 = bowlings.getString("BBI");
                    String wicketsT20 = bowlings.getString("Wkts");
                    String runsbT20 = bowlings.getString("Runs");
                    String ballsbT20 = bowlings.getString("Balls");
                    String inningsbT20 = bowlings.getString("Inns");
                    String matchesbT20 = bowlings.getString("Mat");
                    writeNewPlayerBowlingT20(BattingsBowling[j], pid, tenWicketsT20, fiveWicketsT20, fourWicketsT20, srateT20, economyT20, avgbT20, bbmT20, bbiT20, wicketsT20, runsbT20, ballsbT20, inningsbT20, matchesbT20);

                }
                JSONObject t20 = batting.getJSONObject("tests");
                Log.d("50", t20.getString("50"));


            } catch (JSONException e) {
                System.out.println("EXCEPTION=====" + e);
            }
            Log.i("INFO", response);
        }

        private void writeNewPlayerBowlingT20(String s2, Long pid, String tenWicketsT20, String fiveWicketsT20, String fourWicketsT20, String srateT20, String economyT20, String avgbT20, String bbmT20, String bbiT20, String wicketsT20, String runsbT20, String ballsbT20, String inningsbT20, String matchesbT20) {
            String s3 = s2;

            PlayerPersonalDetailsDB t20BL = new PlayerPersonalDetailsDB(tenWicketsT20, fiveWicketsT20, fourWicketsT20, srateT20, economyT20, avgbT20, bbmT20, bbiT20, wicketsT20, runsbT20, ballsbT20, inningsbT20, matchesbT20);
            mDatabase.child("cricit").child("player stats").child("Details").child(Long.toString(pid)).child("Bowling").child(s3).setValue(t20BL);

        }


        private void writeNewPlayerBattingT20(String s1, Long pid, String fiftiesT20, String hundredsT20, String stumpingT20, String catchesT20, String sixesT20, String foursT20, String srT20, String ballsT20, String avgT20, String hsT20, String runsT20, String notoutT20, String inningsT20, String matchesT20) {
            String s = s1;

            PlayerPersonalDetailsDB t20BT = new PlayerPersonalDetailsDB(fiftiesT20, hundredsT20, stumpingT20, catchesT20, sixesT20, foursT20, srT20, ballsT20, avgT20, hsT20, runsT20, notoutT20, inningsT20, matchesT20);
            mDatabase.child("cricit").child("player stats").child("Details").child(Long.toString(pid)).child("Batting").child(s).setValue(t20BT);
        }


        private void writeNewPlayer(Long pid, String country, String imageURL, String profile, String bowlingStyle, String battingStyle, String majorTeams, String currentAge, String born, String name) {
            PlayerPersonalDetailsDB umdb = new PlayerPersonalDetailsDB(country, imageURL, profile, bowlingStyle, battingStyle, majorTeams, currentAge, born, name);
            mDatabase.child("cricit").child("player stats").child("Details").child(Long.toString(pid)).child("Personal Details").setValue(umdb);
        }
    }
}


