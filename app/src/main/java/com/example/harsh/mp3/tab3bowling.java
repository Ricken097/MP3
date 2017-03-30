package com.example.harsh.mp3;

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

/**
 * Created by Harsh on 3/29/2017.
 */

public class tab3bowling extends Fragment {
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    TextView match1, match2, match3, inn1, inn2, inn3, wicket1, wicket2, wicket3, balls1, balls2, balls3, runs1, runs2, runs3, BBI1, BBI2, BBI3, BBM1, BBM2, BBM3, avg1, avg2, avg3, sr1, sr2, sr3, eco1, eco2, eco3, ten1, ten2, ten3, five1, five2, five3, four1, four2, four3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab3bowling, container, false);
        match1 = (TextView) rootView.findViewById(R.id.match1);
        match2 = (TextView) rootView.findViewById(R.id.match2);
        match3 = (TextView) rootView.findViewById(R.id.match3);
        inn1 = (TextView) rootView.findViewById(R.id.inn1);
        inn2 = (TextView) rootView.findViewById(R.id.inn2);
        inn3 = (TextView) rootView.findViewById(R.id.inn3);
        wicket1 = (TextView) rootView.findViewById(R.id.wicket1);
        wicket2 = (TextView) rootView.findViewById(R.id.wicket2);
        wicket3 = (TextView) rootView.findViewById(R.id.wicket3);
        balls1 = (TextView) rootView.findViewById(R.id.balls1);
        balls2 = (TextView) rootView.findViewById(R.id.balls2);
        balls3 = (TextView) rootView.findViewById(R.id.balls3);
        runs1 = (TextView) rootView.findViewById(R.id.runs1);
        runs2 = (TextView) rootView.findViewById(R.id.runs2);
        runs3 = (TextView) rootView.findViewById(R.id.runs3);
        BBI1 = (TextView) rootView.findViewById(R.id.bbi1);
        BBI2 = (TextView) rootView.findViewById(R.id.bbi2);
        BBI3 = (TextView) rootView.findViewById(R.id.bbi3);
        BBM1 = (TextView) rootView.findViewById(R.id.bbm1);
        BBM2 = (TextView) rootView.findViewById(R.id.bbm2);
        BBM3 = (TextView) rootView.findViewById(R.id.bbm3);
        avg1= (TextView) rootView.findViewById(R.id.avg1);
        avg2 = (TextView) rootView.findViewById(R.id.avg2);
        avg3 = (TextView) rootView.findViewById(R.id.avg3);
        eco1 = (TextView) rootView.findViewById(R.id.eco1);
        eco2 = (TextView) rootView.findViewById(R.id.eco2);
        eco3 = (TextView) rootView.findViewById(R.id.eco3);
        sr1 = (TextView) rootView.findViewById(R.id.sr1);
        sr2 = (TextView) rootView.findViewById(R.id.sr2);
        sr3 = (TextView) rootView.findViewById(R.id.sr3);
        ten1 = (TextView) rootView.findViewById(R.id.ten1);
        ten2 = (TextView) rootView.findViewById(R.id.ten2);
        ten3 = (TextView) rootView.findViewById(R.id.ten3);
        five1 = (TextView) rootView.findViewById(R.id.five1);
        five2 = (TextView) rootView.findViewById(R.id.five2);
        five3 = (TextView) rootView.findViewById(R.id.five3);
        four1 = (TextView) rootView.findViewById(R.id.four1);
        four2 = (TextView) rootView.findViewById(R.id.four2);
        four3 = (TextView) rootView.findViewById(R.id.four3);

        DatabaseReference mPlayerBowlingDetailsT20Is = database.getReference("cricit/player stats/Details/" + pid + "/Bowling/T20Is");
        mPlayerBowlingDetailsT20Is.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot ds) {
                String a = (String) ds.child("avgb").getValue();
                avg3.setText(a);
                String b = (String) ds.child("ballsb").getValue();
                balls3.setText(b);
                String c = (String) ds.child("bbi").getValue();
                BBI3.setText(c);
                String d = (String) ds.child("bbm").getValue();
                BBM3.setText(d);
                String e = (String) ds.child("economy").getValue();
                eco3.setText(e);
                String f = (String) ds.child("fives").getValue();
                five3.setText(f);
                String g = (String) ds.child("foursb").getValue();
                four3.setText(g);
                String h = (String) ds.child("inningsb").getValue();
                inn3.setText(h);
                String i = (String) ds.child("matchesb").getValue();
                match3.setText(i);
                String j = (String) ds.child("runsb").getValue();
                runs3.setText(j);
                String k = (String) ds.child("srate").getValue();
                sr3.setText(k);
                String l = (String) ds.child("tens").getValue();
                ten3.setText(l);
                String m = (String) ds.child("wickets").getValue();
                wicket3.setText(m);
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
                avg2.setText(a);
                String b = (String) ds.child("ballsb").getValue();
                balls2.setText(b);
                String c = (String) ds.child("bbi").getValue();
                BBI2.setText(c);
                String d = (String) ds.child("bbm").getValue();
                BBM2.setText(d);
                String e = (String) ds.child("economy").getValue();
                eco2.setText(e);
                String f = (String) ds.child("fives").getValue();
                five2.setText(f);
                String g = (String) ds.child("foursb").getValue();
                four2.setText(g);
                String h = (String) ds.child("inningsb").getValue();
                inn2.setText(h);
                String i = (String) ds.child("matchesb").getValue();
                match2.setText(i);
                String j = (String) ds.child("runsb").getValue();
                runs2.setText(j);
                String k = (String) ds.child("srate").getValue();
                sr2.setText(k);
                String l = (String) ds.child("tens").getValue();
                ten2.setText(l);
                String m = (String) ds.child("wickets").getValue();
                wicket2.setText(m);
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
                avg1.setText(a);
                String b = (String) ds.child("ballsb").getValue();
                balls1.setText(b);
                String c = (String) ds.child("bbi").getValue();
                BBI1.setText(c);
                String d = (String) ds.child("bbm").getValue();
                BBM1.setText(d);
                String e = (String) ds.child("economy").getValue();
                eco1.setText(e);
                String f = (String) ds.child("fives").getValue();
                five1.setText(f);
                String g = (String) ds.child("foursb").getValue();
                four1.setText(g);
                String h = (String) ds.child("inningsb").getValue();
                inn1.setText(h);
                String i = (String) ds.child("matchesb").getValue();
                match1.setText(i);
                String j = (String) ds.child("runsb").getValue();
                runs1.setText(j);
                String k = (String) ds.child("srate").getValue();
                sr1.setText(k);
                String l = (String) ds.child("tens").getValue();
                ten1.setText(l);
                String m = (String) ds.child("wickets").getValue();
                wicket1.setText(m);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return rootView;
    }
}
