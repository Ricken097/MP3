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
public class Home extends Fragment {

    ListView list1, list2;
    String title1;

    DatabaseReference mRef = FirebaseDatabase.getInstance().getReference();
    View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        rootView = inflater.inflate(R.layout.fragment_home, container, false);

        String[] myitems = {"India Vs Australia", "England Vs West Indies", "South Africa Vs New Zealand"};
        list1 = (ListView) rootView.findViewById(R.id.lv1);

        ArrayAdapter<String> adapterScore = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, myitems);
        list1.setAdapter(adapterScore);


        DatabaseReference mRootName = mRef.child("cricit").child("news");
        final List<String> listinnews = new ArrayList<String>();

        ValueEventListener valueEventListener = mRootName.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    listinnews.add(String.valueOf(dsp.getKey()));
                }
                ArrayAdapter<String> adapterNews = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, listinnews);
                list2 = (ListView) rootView.findViewById(R.id.lv2);
                list2.setAdapter(adapterNews);

                AdapterView.OnItemClickListener mMessageClickedHandler = new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView parent, View v, int position, long id) {
                        String clickValueHistory =(String) (list2.getItemAtPosition(position));
                        NewsDetails th = new NewsDetails();
                        th.sendValue(clickValueHistory);

                        Intent intent = new Intent(v.getContext(), Temporary.class);
                        startActivity(intent);
                    }
                };

                list2.setOnItemClickListener(mMessageClickedHandler);
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return rootView;
    }


}


