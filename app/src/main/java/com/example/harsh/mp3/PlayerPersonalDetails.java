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

public class PlayerPersonalDetails extends AsyncTask<Void, Void, String> {
    static Long pid;
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    private Exception exception;

    public void sendPid(long pid) {
        PlayerPersonalDetails.pid = pid;
    }

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


            String fullName = object.getString("fullName");
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


            // JSONArray matches = data.getJSONArray("matches");
            JSONObject data = object.getJSONObject("data");
            JSONObject batting = data.getJSONObject("batting");
            JSONObject bowling = data.getJSONObject("bowling");


            JSONObject battingT20 = batting.getJSONObject("T20Is");
            String fiftiesT20 = battingT20.getString("50");
            String hundredsT20 = battingT20.getString("100");
            String stumpingT20 = battingT20.getString("St");
            String catchesT20 = battingT20.getString("Ct");
            String sixesT20 = battingT20.getString("6s");
            String foursT20 = battingT20.getString("4s");
            String srT20 = battingT20.getString("SR");
            String ballsT20 = battingT20.getString("BF");
            String avgT20 = battingT20.getString("Ave");
            String hsT20 = battingT20.getString("HS");
            String runsT20 = battingT20.getString("Runs");
            String notoutT20 = battingT20.getString("NO");
            String inningsT20 = battingT20.getString("Inns");
            String matchesT20 = battingT20.getString("Mat");
            writeNewPlayerBattingT20(pid, fiftiesT20, hundredsT20, stumpingT20, catchesT20, sixesT20, foursT20, srT20, ballsT20, avgT20, hsT20, runsT20, notoutT20, inningsT20, matchesT20);

            JSONObject battingODIs = batting.getJSONObject("ODIs");
            String fiftiesODI = battingODIs.getString("50");
            String hundredsODI = battingODIs.getString("100");
            String stumpingODI = battingODIs.getString("St");
            String catchesODI = battingODIs.getString("Ct");
            String sixesODI = battingODIs.getString("6s");
            String foursODI = battingODIs.getString("4s");
            String srODI = battingODIs.getString("SR");
            String ballsODI = battingODIs.getString("BF");
            String avgODI = battingODIs.getString("Ave");
            String hsODI = battingODIs.getString("HS");
            String runsODI = battingODIs.getString("Runs");
            String notoutODI = battingODIs.getString("NO");
            String inningsODI = battingODIs.getString("Inns");
            String matchesODI = battingODIs.getString("Mat");
            writeNewPlayerBattingODIs(pid, fiftiesODI, hundredsODI, stumpingODI, catchesODI, sixesODI, foursODI, srODI, ballsODI, avgODI, hsODI, runsODI, notoutODI, inningsODI, matchesODI);


            JSONObject battingtests = batting.getJSONObject("tests");
            String fiftiestests = battingtests.getString("50");
            String hundredstests = battingtests.getString("100");
            int hundredstestss = battingtests.getInt("100");
            System.out.println("FULLNAME TOTALCENTURIES====" + hundredstestss);
            String stumpingtests = battingtests.getString("St");
            String catchestests = battingtests.getString("Ct");
            String sixestests = battingtests.getString("6s");
            String fourstests = battingtests.getString("4s");
            String srtests = battingtests.getString("SR");
            String ballstests = battingtests.getString("BF");
            String avgtests = battingtests.getString("Ave");
            String hstests = battingtests.getString("HS");
            String runstests = battingtests.getString("Runs");
            String notouttests = battingtests.getString("NO");
            String inningstests = battingtests.getString("Inns");
            String matchestests = battingtests.getString("Mat");
            writeNewPlayerBattingtests(pid, fiftiestests, hundredstests, stumpingtests, catchestests, sixestests, fourstests, srtests, ballstests, avgtests, hstests, runstests, notouttests, inningstests, matchestests);


            JSONObject bowlingT20 = bowling.getJSONObject("T20Is");
            String tenWicketsT20 = bowlingT20.getString("10");
            String fiveWicketsT20 = bowlingT20.getString("5w");
            String fourWicketsT20 = bowlingT20.getString("4w");
            String srateT20 = bowlingT20.getString("SR");
            String economyT20 = bowlingT20.getString("Econ");
            String avgbT20 = bowlingT20.getString("Ave");
            String bbmT20 = bowlingT20.getString("BBM");
            String bbiT20 = bowlingT20.getString("BBI");
            String wicketsT20 = bowlingT20.getString("Wkts");
            String runsbT20 = bowlingT20.getString("Runs");
            String ballsbT20 = bowlingT20.getString("Balls");
            String inningsbT20 = bowlingT20.getString("Inns");
            String matchesbT20 = bowlingT20.getString("Mat");
            writeNewPlayerBowlingT20(pid, tenWicketsT20, fiveWicketsT20, fourWicketsT20, srateT20, economyT20, avgbT20, bbmT20, bbiT20, wicketsT20, runsbT20, ballsbT20, inningsbT20, matchesbT20);


            JSONObject bowlingODIs = bowling.getJSONObject("ODIs");
            String tenWicketsODIs = bowlingODIs.getString("10");
            String fiveWicketsODIs = bowlingODIs.getString("5w");
            String fourWicketsODIs = bowlingODIs.getString("4w");
            String srateODIs = bowlingODIs.getString("SR");
            String economyODIs = bowlingODIs.getString("Econ");
            String avgbODIs = bowlingODIs.getString("Ave");
            String bbmODIs = bowlingODIs.getString("BBM");
            String bbiODIs = bowlingODIs.getString("BBI");
            String wicketsODIs = bowlingODIs.getString("Wkts");
            String runsbODIs = bowlingODIs.getString("Runs");
            String ballsbODIs = bowlingODIs.getString("Balls");
            String inningsbODIs = bowlingODIs.getString("Inns");
            String matchesbODIs = bowlingODIs.getString("Mat");
            writeNewPlayerBowlingODIs(pid, tenWicketsODIs, fiveWicketsODIs, fourWicketsODIs, srateODIs, economyODIs, avgbODIs, bbmODIs, bbiODIs, wicketsODIs, runsbODIs, ballsbODIs, inningsbODIs, matchesbODIs);


            JSONObject bowlingtests = bowling.getJSONObject("tests");
            String tenWicketstests = bowlingtests.getString("10");
            String fiveWicketstests = bowlingtests.getString("5w");
            String fourWicketstests = bowlingtests.getString("4w");
            String sratetests = bowlingtests.getString("SR");
            String economytests = bowlingtests.getString("Econ");
            String avgbtests = bowlingtests.getString("Ave");
            String bbmtests = bowlingtests.getString("BBM");
            String bbitests = bowlingtests.getString("BBI");
            String wicketstests = bowlingtests.getString("Wkts");
            String runsbtests = bowlingtests.getString("Runs");
            String ballsbtests = bowlingtests.getString("Balls");
            String inningsbtests = bowlingtests.getString("Inns");
            String matchesbtests = bowlingtests.getString("Mat");
            writeNewPlayerBowlingtests(pid, tenWicketstests, fiveWicketstests, fourWicketstests, sratetests, economytests, avgbtests, bbmtests, bbitests, wicketstests, runsbtests, ballsbtests, inningsbtests, matchesbtests);


        } catch (JSONException e) {
            // Appropriate error handling code
        }
        Log.i("INFO", response);
    }

    private void writeNewPlayerBowlingtests(Long pid, String tenWicketstests, String fiveWicketstests, String fourWicketstests, String sratetests, String economytests, String avgbtests, String bbmtests, String bbitests, String wicketstests, String runsbtests, String ballsbtests, String inningsbtests, String matchesbtests) {
        PlayerPersonalDetailsDB testsBL = new PlayerPersonalDetailsDB(tenWicketstests, fiveWicketstests, fourWicketstests, sratetests, economytests, avgbtests, bbmtests, bbitests, wicketstests, runsbtests, ballsbtests, inningsbtests, matchesbtests);
        mDatabase.child("cricit").child("player stats").child("Details").child(Long.toString(pid)).child("Bowling").child("tests").setValue(testsBL);
    }

    private void writeNewPlayerBowlingODIs(Long pid, String tenWicketsODIs, String fiveWicketsODIs, String fourWicketsODIs, String srateODIs, String economyODIs, String avgbODIs, String bbmODIs, String bbiODIs, String wicketsODIs, String runsbODIs, String ballsbODIs, String inningsbODIs, String matchesbODIs) {
        PlayerPersonalDetailsDB odiBL = new PlayerPersonalDetailsDB(tenWicketsODIs, fiveWicketsODIs, fourWicketsODIs, srateODIs, economyODIs, avgbODIs, bbmODIs, bbiODIs, wicketsODIs, runsbODIs, ballsbODIs, inningsbODIs, matchesbODIs);
        mDatabase.child("cricit").child("player stats").child("Details").child(Long.toString(pid)).child("Bowling").child("ODIs").setValue(odiBL);
    }

    private void writeNewPlayerBowlingT20(Long pid, String tenWicketsT20, String fiveWicketsT20, String fourWicketsT20, String srateT20, String economyT20, String avgbT20, String bbmT20, String bbiT20, String wicketsT20, String runsbT20, String ballsbT20, String inningsbT20, String matchesbT20) {
        PlayerPersonalDetailsDB t20BL = new PlayerPersonalDetailsDB(tenWicketsT20, fiveWicketsT20, fourWicketsT20, srateT20, economyT20, avgbT20, bbmT20, bbiT20, wicketsT20, runsbT20, ballsbT20, inningsbT20, matchesbT20);
        mDatabase.child("cricit").child("player stats").child("Details").child(Long.toString(pid)).child("Bowling").child("T20").setValue(t20BL);

    }

    private void writeNewPlayerBattingODIs(Long pid, String fiftiesODI, String hundredsODI, String stumpingODI, String catchesODI, String sixesODI, String foursODI, String srODI, String ballsODI, String avgODI, String hsODI, String runsODI, String notoutODI, String inningsODI, String matchesODI) {
        PlayerPersonalDetailsDB odiBT = new PlayerPersonalDetailsDB(fiftiesODI, hundredsODI, stumpingODI, catchesODI, sixesODI, foursODI, srODI, ballsODI, avgODI, hsODI, runsODI, notoutODI, inningsODI, matchesODI);
        mDatabase.child("cricit").child("player stats").child("Details").child(Long.toString(pid)).child("Batting").child("ODIs").setValue(odiBT);
    }

    private void writeNewPlayerBattingT20(Long pid, String fiftiesT20, String hundredsT20, String stumpingT20, String catchesT20, String sixesT20, String foursT20, String srT20, String ballsT20, String avgT20, String hsT20, String runsT20, String notoutT20, String inningsT20, String matchesT20) {
        PlayerPersonalDetailsDB t20BT = new PlayerPersonalDetailsDB(fiftiesT20, hundredsT20, stumpingT20, catchesT20, sixesT20, foursT20, srT20, ballsT20, avgT20, hsT20, runsT20, notoutT20, inningsT20, matchesT20);
        mDatabase.child("cricit").child("player stats").child("Details").child(Long.toString(pid)).child("Batting").child("T20").setValue(t20BT);
    }

    private void writeNewPlayerBattingtests(Long pid, String fiftiestests, String hundredstests, String stumpingtests, String catchestests, String sixestests, String fourstests, String srtests, String ballstests, String avgtests, String hstests, String runstests, String notouttests, String inningstests, String matchestests) {
        PlayerPersonalDetailsDB testsBT = new PlayerPersonalDetailsDB(fiftiestests, hundredstests, stumpingtests, catchestests, sixestests, fourstests, srtests, ballstests, avgtests, hstests, runstests, notouttests, inningstests, matchestests);
        mDatabase.child("cricit").child("player stats").child("Details").child(Long.toString(pid)).child("Batting").child("tests").setValue(testsBT);
    }

    private void writeNewPlayer(Long pid, String country, String imageURL, String profile, String bowlingStyle, String battingStyle, String majorTeams, String currentAge, String born, String name) {
        PlayerPersonalDetailsDB umdb = new PlayerPersonalDetailsDB(country, imageURL, profile, bowlingStyle, battingStyle, majorTeams, currentAge, born, name);
        mDatabase.child("cricit").child("player stats").child("Details").child(Long.toString(pid)).child("Personal Details").setValue(umdb);
    }
}


