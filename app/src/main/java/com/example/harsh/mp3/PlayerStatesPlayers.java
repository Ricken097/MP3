package com.example.harsh.mp3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
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

public class PlayerStatesPlayers extends AppCompatActivity {
    static String TeamName, team, player;
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    ListView listView;
    long pid;
    DatabaseReference mRef = FirebaseDatabase.getInstance().getReference();
    AdapterView.OnItemClickListener mMessageClickedHandler = new AdapterView.OnItemClickListener() {

        public void onItemClick(AdapterView parent, View v, int position, long id) {
            String clickValuePlayer = (String) (listView.getItemAtPosition(position));
            PlayerStatesPlayers tn = new PlayerStatesPlayers();

            DatabaseReference mPlayerId = database.getReference("cricit/player stats/Team/" + TeamName + "/" + clickValuePlayer);

            System.out.println("In fetchfromAPIPlayerTEAMNAME=" + TeamName);
            System.out.println("In fetchfromAPIPlayerPLAYERNAME=" + clickValuePlayer);
            mPlayerId.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot ds) {
                    pid = (Long) ds.child("pid").getValue();
                    System.out.println("In PLAYERMENU ID=====" + pid);
                    PlayerPersonalDetails ppd = new PlayerPersonalDetails();
                    ppd.sendPid(pid);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


            System.out.println("PLAYERID IN PLAYERSTATESPLAYER" + pid);


            Intent intent = new Intent(v.getContext(), Temp.class);
            startActivity(intent);
            PlayerStatesPlayers.this.finish();

        }
    };

    public void sendValue(String clickValueTeam) {
        PlayerStatesPlayers.TeamName = clickValueTeam;
        System.out.println(TeamName + "+++++++++++");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_states_players);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DatabaseReference mRootName = mRef.child("cricit").child("player stats").child("Team").child(TeamName);

        final List<String> listinteams = new ArrayList<String>();

        ValueEventListener valueEventListener = mRootName.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    listinteams.add(String.valueOf(dsp.getKey()));
                }
                ArrayAdapter<String> adapterPlayers = new ArrayAdapter<String>(PlayerStatesPlayers.this, android.R.layout.simple_list_item_1, listinteams);
                listView = (ListView) findViewById(R.id.playerlist);
                listView.setAdapter(adapterPlayers);
                listView.setOnItemClickListener(mMessageClickedHandler);
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
