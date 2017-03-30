package com.example.harsh.mp3;

/**
 * Created by Harsh on 3/29/2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.example.harsh.mp3.PlayerPersonalDetails.pid;

public class tab1bio extends Fragment{
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    TextView name,country,dob,age,bat_style,bowling_style,teams,info;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.tab1bio, container, false);

        name = (TextView) rootView.findViewById(R.id.name);
        dob = (TextView) rootView.findViewById(R.id.dob);
        age = (TextView) rootView.findViewById(R.id.age);
        bat_style = (TextView) rootView.findViewById(R.id.bat_style);
        bowling_style = (TextView) rootView.findViewById(R.id.bowling_style);
        teams = (TextView) rootView.findViewById(R.id.teams);
        info = (TextView) rootView.findViewById(R.id.info);
        country = (TextView) rootView.findViewById(R.id.country);

        DatabaseReference mPlayerPersonalDetails = database.getReference("cricit/player stats/Details/" + pid + "/Personal Details");

        mPlayerPersonalDetails.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot ds) {
                String a = (String) ds.child("battingStyle").getValue();
                bat_style.setText(a);
                String b = (String) ds.child("born").getValue();
                dob.setText(b);
                String c = (String) ds.child("bowlingStyle").getValue();
                bowling_style.setText(c);
                String d = (String) ds.child("country").getValue();
                country.setText(d);
                String e = (String) ds.child("currentAge").getValue();
                age.setText(e);
                String f = (String) ds.child("imageURL").getValue();
                String g = (String) ds.child("majorTeams").getValue();
                teams.setText(g);
                String h = (String) ds.child("name").getValue();
                name.setText(h);
                String i = (String) ds.child("profile").getValue();
                info.setText(i);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        return rootView;
    }
}
