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

public class tab3bowling extends Fragment {
    TextView match1,match2,match3,inn1,inn2,inn3,balls1,balls2,balls3,runs1,runs2,runs3,BBI1,BBI2,BBI3,BBM1,BBM2,BBM3,avg1,avg2,avg3,sr1,sr2,sr3,eco1,eco2,eco3,ten1,ten2,ten3,five1,five2,five3,four1,four2,four3;
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

        return rootView;
    }
}
