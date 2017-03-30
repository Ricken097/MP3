package com.example.harsh.mp3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.example.harsh.mp3.PlayerPersonalDetails.pid;

public class Temp extends AppCompatActivity {
    final FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DatabaseReference mPlayerPersonalDetails = database.getReference("cricit/player stats/Details/" + pid + "/Personal Details");

        mPlayerPersonalDetails.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot ds) {
                String a = (String) ds.child("battingStyle").getValue();
                String b = (String) ds.child("born").getValue();
                String c = (String) ds.child("bowlingStyle").getValue();
                String d = (String) ds.child("country").getValue();
                String e = (String) ds.child("currentAge").getValue();
                String f = (String) ds.child("imageURL").getValue();
                String g = (String) ds.child("majorTeams").getValue();
                String h = (String) ds.child("name").getValue();
                String i = (String) ds.child("profile").getValue();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        DatabaseReference mPlayerBattingDetailsT20Is = database.getReference("cricit/player stats/Details/" + pid + "/Batting/T20Is");
        mPlayerBattingDetailsT20Is.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot ds) {
                String a = (String) ds.child("avg").getValue();
                System.out.println("AVG" + a);
                String b = (String) ds.child("ballfaced").getValue();
                String c = (String) ds.child("catches").getValue();
                String d = (String) ds.child("fifties").getValue();
                String e = (String) ds.child("fours").getValue();
                String f = (String) ds.child("highest").getValue();
                String g = (String) ds.child("hundreds").getValue();
                String h = (String) ds.child("innings").getValue();
                String i = (String) ds.child("matches").getValue();
                String j = (String) ds.child("notout").getValue();
                String k = (String) ds.child("runs").getValue();
                String l = (String) ds.child("sixes").getValue();
                String m = (String) ds.child("sr").getValue();
                String n = (String) ds.child("stumping").getValue();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        DatabaseReference mPlayerBattingDetailsODIs = database.getReference("cricit/player stats/Details/" + pid + "/Batting/ODIs");
        mPlayerBattingDetailsODIs.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot ds) {
                String a = (String) ds.child("avg").getValue();
                String b = (String) ds.child("ballfaced").getValue();
                String c = (String) ds.child("catches").getValue();
                String d = (String) ds.child("fifties").getValue();
                String e = (String) ds.child("fours").getValue();
                System.out.println("FOURS" + e);
                String f = (String) ds.child("highest").getValue();
                String g = (String) ds.child("hundreds").getValue();
                String h = (String) ds.child("innings").getValue();
                String i = (String) ds.child("matches").getValue();
                String j = (String) ds.child("notout").getValue();
                String k = (String) ds.child("runs").getValue();
                String l = (String) ds.child("sixes").getValue();
                String m = (String) ds.child("sr").getValue();
                String n = (String) ds.child("stumping").getValue();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        DatabaseReference mPlayerBattingDetailstests = database.getReference("cricit/player stats/Details/" + pid + "/Batting/tests");
        mPlayerBattingDetailstests.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot ds) {
                String a = (String) ds.child("avg").getValue();
                String b = (String) ds.child("ballfaced").getValue();
                String c = (String) ds.child("catches").getValue();
                String d = (String) ds.child("fifties").getValue();
                String e = (String) ds.child("fours").getValue();
                String f = (String) ds.child("highest").getValue();
                String g = (String) ds.child("hundreds").getValue();
                String h = (String) ds.child("innings").getValue();
                String i = (String) ds.child("matches").getValue();
                String j = (String) ds.child("notout").getValue();
                String k = (String) ds.child("runs").getValue();
                String l = (String) ds.child("sixes").getValue();
                String m = (String) ds.child("sr").getValue();
                String n = (String) ds.child("stumping").getValue();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        DatabaseReference mPlayerBowlingDetailsT20Is = database.getReference("cricit/player stats/Details/" + pid + "/Bowling/T20Is");
        mPlayerBowlingDetailsT20Is.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot ds) {
                String a = (String) ds.child("avgb").getValue();
                String b = (String) ds.child("ballsb").getValue();
                String c = (String) ds.child("bbi").getValue();
                String d = (String) ds.child("bbm").getValue();
                String e = (String) ds.child("economy").getValue();
                String f = (String) ds.child("fives").getValue();
                String g = (String) ds.child("foursb").getValue();
                String h = (String) ds.child("inningsb").getValue();
                String i = (String) ds.child("matchesb").getValue();
                String j = (String) ds.child("runsb").getValue();
                String k = (String) ds.child("srate").getValue();
                String l = (String) ds.child("tens").getValue();
                String m = (String) ds.child("wickets").getValue();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        DatabaseReference mPlayerBowlingDetailsODIs = database.getReference("cricit/player stats/Details/" + pid + "/Bowling/ODIs");
        mPlayerBowlingDetailsODIs.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot ds) {
                String a = (String) ds.child("avgb").getValue();
                System.out.println("AVGBOWLING" + a);
                String b = (String) ds.child("ballsb").getValue();
                String c = (String) ds.child("bbi").getValue();
                String d = (String) ds.child("bbm").getValue();
                String e = (String) ds.child("economy").getValue();
                String f = (String) ds.child("fives").getValue();
                String g = (String) ds.child("foursb").getValue();
                String h = (String) ds.child("inningsb").getValue();
                String i = (String) ds.child("matchesb").getValue();
                String j = (String) ds.child("runsb").getValue();
                String k = (String) ds.child("srate").getValue();
                String l = (String) ds.child("tens").getValue();
                String m = (String) ds.child("wickets").getValue();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        DatabaseReference mPlayerBowlingDetailstests = database.getReference("cricit/player stats/Details/" + pid + "/Bowling/tests");
        mPlayerBowlingDetailstests.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot ds) {
                String a = (String) ds.child("avgb").getValue();
                String b = (String) ds.child("ballsb").getValue();
                String c = (String) ds.child("bbi").getValue();
                String d = (String) ds.child("bbm").getValue();
                String e = (String) ds.child("economy").getValue();
                String f = (String) ds.child("fives").getValue();
                String g = (String) ds.child("foursb").getValue();
                String h = (String) ds.child("inningsb").getValue();
                String i = (String) ds.child("matchesb").getValue();
                String j = (String) ds.child("runsb").getValue();
                String k = (String) ds.child("srate").getValue();
                String l = (String) ds.child("tens").getValue();
                String m = (String) ds.child("wickets").getValue();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PlayerStatesPlayers.class);
                startActivity(intent);
                Temp.this.finish();
            }
        });


    }

}
