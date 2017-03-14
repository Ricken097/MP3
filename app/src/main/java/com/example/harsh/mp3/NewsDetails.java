package com.example.harsh.mp3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class NewsDetails extends AppCompatActivity {

    static String clickValue;
    TextView news, para;
    DatabaseReference mRef = FirebaseDatabase.getInstance().getReference();


    public void sendValue(String clickValueHistory) {
        NewsDetails.clickValue = clickValueHistory;
        System.out.println("clicked value=" + clickValue);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        para = (TextView) findViewById(R.id.NewsHead);
        para.setText(clickValue);

        news = (TextView) findViewById(R.id.NewsPara);
        news.setMovementMethod(new ScrollingMovementMethod());


        DatabaseReference mRootName = mRef.child("cricit").child("news").child(clickValue);

        mRootName.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String detailedNews = dataSnapshot.getValue(String.class);
                news.setText(detailedNews);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}

