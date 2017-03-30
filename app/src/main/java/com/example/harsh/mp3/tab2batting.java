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

public class tab2batting extends Fragment {
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    TextView match1,match2,match3,inn1,inn2,inn3,balls1,balls2,balls3,runs1,runs2,runs3,high1,high2,high3,avg1,avg2,avg3,sr1,sr2,sr3,boun1,boun2,boun3,six1,six2,six3,catch1,catch2,catch3,stump1,stump2,stump3,no1,no2,no3,hal1,hal2,hal3,cen1,cen2,cen3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab2batting, container, false);
        match1 = (TextView) rootView.findViewById(R.id.match1);
        match2 = (TextView) rootView.findViewById(R.id.match2);
        match3 = (TextView) rootView.findViewById(R.id.match3);
        inn1 = (TextView) rootView.findViewById(R.id.inn1);
        inn2 = (TextView) rootView.findViewById(R.id.inn2);
        inn3 = (TextView) rootView.findViewById(R.id.inn3);
        balls1 = (TextView) rootView.findViewById(R.id.balls1);
        balls2 = (TextView) rootView.findViewById(R.id.balls2);
        balls3 = (TextView) rootView.findViewById(R.id.balls3);
        runs1 = (TextView) rootView.findViewById(R.id.runs1);
        runs2 = (TextView) rootView.findViewById(R.id.runs2);
        runs3 = (TextView) rootView.findViewById(R.id.runs3);
        high1 = (TextView) rootView.findViewById(R.id.high1);
        high2 = (TextView) rootView.findViewById(R.id.high2);
        high3 = (TextView) rootView.findViewById(R.id.high3);
        avg1= (TextView) rootView.findViewById(R.id.avg1);
        avg2 = (TextView) rootView.findViewById(R.id.avg2);
        avg3 = (TextView) rootView.findViewById(R.id.avg3);
        sr1 = (TextView) rootView.findViewById(R.id.sr1);
        sr2 = (TextView) rootView.findViewById(R.id.sr2);
        sr3 = (TextView) rootView.findViewById(R.id.sr3);
        boun1 = (TextView) rootView.findViewById(R.id.boun1);
        boun2 = (TextView) rootView.findViewById(R.id.boun2);
        boun3 = (TextView) rootView.findViewById(R.id.boun3);
        six1 = (TextView) rootView.findViewById(R.id.six1);
        six2 = (TextView) rootView.findViewById(R.id.six2);
        six3 = (TextView) rootView.findViewById(R.id.six3);
        catch1 = (TextView) rootView.findViewById(R.id.catch1);
        catch2 = (TextView) rootView.findViewById(R.id.catch2);
        catch3 = (TextView) rootView.findViewById(R.id.catch3);
        stump1 = (TextView) rootView.findViewById(R.id.stump1);
        stump2 = (TextView) rootView.findViewById(R.id.stump2);
        stump3 = (TextView) rootView.findViewById(R.id.stump3);
        no1 = (TextView) rootView.findViewById(R.id.no1);
        no2 = (TextView) rootView.findViewById(R.id.no2);
        no3 = (TextView) rootView.findViewById(R.id.no3);
        hal1 = (TextView) rootView.findViewById(R.id.hal1);
        hal2 = (TextView) rootView.findViewById(R.id.hal2);
        hal3 = (TextView) rootView.findViewById(R.id.hal3);
        cen1 = (TextView) rootView.findViewById(R.id.cen1);
        cen2 = (TextView) rootView.findViewById(R.id.cen2);
        cen3 = (TextView) rootView.findViewById(R.id.cen3);

        DatabaseReference mPlayerBattingDetailsT20Is = database.getReference("cricit/player stats/Details/" + pid + "/Batting/T20Is");
        mPlayerBattingDetailsT20Is.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot ds) {
                String a = (String) ds.child("avg").getValue();
                avg3.setText(a);
                String b = (String) ds.child("ballfaced").getValue();
                balls3.setText(b);
                String c = (String) ds.child("catches").getValue();
                catch3.setText(c);
                String d = (String) ds.child("fifties").getValue();
                hal3.setText(d);
                String e = (String) ds.child("fours").getValue();
                boun3.setText(e);
                String f = (String) ds.child("highest").getValue();
                high3.setText(f);
                String g = (String) ds.child("hundreds").getValue();
                cen3.setText(g);
                String h = (String) ds.child("innings").getValue();
                inn3.setText(h);
                String i = (String) ds.child("matches").getValue();
                match3.setText(i);
                String j = (String) ds.child("notout").getValue();
                no3.setText(j);
                String k = (String) ds.child("runs").getValue();
                runs3.setText(k);
                String l = (String) ds.child("sixes").getValue();
                six3.setText(l);
                String m = (String) ds.child("sr").getValue();
                sr3.setText(m);
                String n = (String) ds.child("stumping").getValue();
                stump3.setText(n);
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
                avg2.setText(a);
                String b = (String) ds.child("ballfaced").getValue();
                balls2.setText(b);
                String c = (String) ds.child("catches").getValue();
                catch2.setText(c);
                String d = (String) ds.child("fifties").getValue();
                hal2.setText(d);
                String e = (String) ds.child("fours").getValue();
                boun2.setText(e);
                String f = (String) ds.child("highest").getValue();
                high2.setText(f);
                String g = (String) ds.child("hundreds").getValue();
                cen2.setText(g);
                String h = (String) ds.child("innings").getValue();
                inn2.setText(h);
                String i = (String) ds.child("matches").getValue();
                match2.setText(i);
                String j = (String) ds.child("notout").getValue();
                no2.setText(j);
                String k = (String) ds.child("runs").getValue();
                runs2.setText(k);
                String l = (String) ds.child("sixes").getValue();
                six2.setText(l);
                String m = (String) ds.child("sr").getValue();
                sr2.setText(m);
                String n = (String) ds.child("stumping").getValue();
                stump2.setText(n);
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
                avg1.setText(a);
                String b = (String) ds.child("ballfaced").getValue();
                balls1.setText(b);
                String c = (String) ds.child("catches").getValue();
                catch1.setText(c);
                String d = (String) ds.child("fifties").getValue();
                hal1.setText(d);
                String e = (String) ds.child("fours").getValue();
                boun1.setText(e);
                String f = (String) ds.child("highest").getValue();
                high1.setText(f);
                String g = (String) ds.child("hundreds").getValue();
                cen1.setText(g);
                String h = (String) ds.child("innings").getValue();
                inn1.setText(h);
                String i = (String) ds.child("matches").getValue();
                match1.setText(i);
                String j = (String) ds.child("notout").getValue();
                no1.setText(j);
                String k = (String) ds.child("runs").getValue();
                runs1.setText(k);
                String l = (String) ds.child("sixes").getValue();
                six1.setText(l);
                String m = (String) ds.child("sr").getValue();
                sr1.setText(m);
                String n = (String) ds.child("stumping").getValue();
                stump1.setText(n);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return rootView;
    }
}