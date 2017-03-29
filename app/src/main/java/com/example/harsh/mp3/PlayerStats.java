package com.example.harsh.mp3;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlayerStats extends Fragment {
    static String team, player;
    int count = 0;
    String teamName;
    ListView listView;
    View rootView;
    DatabaseReference mRef = FirebaseDatabase.getInstance().getReference();
    String p_id;

    public PlayerStats() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_player_stats, container, false);

        DatabaseReference mRootName = mRef.child("cricit").child("player stats").child("Team");
        final List<String> listinstats = new ArrayList<String>();


        ValueEventListener valueEventListener = mRootName.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    listinstats.add(String.valueOf(dsp.getKey()));
                    count++;
                }

                ArrayAdapter<String> adapterNews = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, listinstats);
                listView = (ListView) rootView.findViewById(R.id.teamlist);
                listView.setAdapter(adapterNews);

                PlayerStats ps = new PlayerStats();
                AdapterView.OnItemClickListener mMessageClickedHandler = new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView parent, View v, int position, long id) {
                        String clickValueTeam = (String) (listView.getItemAtPosition(position));
                        PlayerStatesPlayers tn = new PlayerStatesPlayers();
                        tn.sendValue(clickValueTeam);

                        Intent intent = new Intent(v.getContext(), PlayerStatesPlayers.class);
                        startActivity(intent);
                    }
                };

                listView.setOnItemClickListener(mMessageClickedHandler);
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return rootView;
    }

}
