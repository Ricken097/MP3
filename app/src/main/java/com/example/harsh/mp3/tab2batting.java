package com.example.harsh.mp3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Harsh on 3/29/2017.
 */

public class tab2batting extends Fragment {
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

        return rootView;
    }
}