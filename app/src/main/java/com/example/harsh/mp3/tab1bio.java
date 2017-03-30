package com.example.harsh.mp3;

/**
 * Created by Harsh on 3/29/2017.
 */

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class tab1bio extends Fragment{
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

        return rootView;
    }
}
