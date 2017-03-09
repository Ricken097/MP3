package com.example.harsh.mp3;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
        DatabaseReference mRef= FirebaseDatabase.getInstance().getReference();
    ListView list1;
    private FragmentTransaction fragmentTransaction;
        String abc="content_main";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


           android.support.v4.app.FragmentManager fragmentManager=getSupportFragmentManager();

          fragmentTransaction=fragmentManager.beginTransaction();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.Home) {
            Home myFragment2=new Home();
            populateListView();
            registerClickCallback();
            fragmentTransaction.replace(R.id.content_main,myFragment2);
            fragmentTransaction.commit();

        } else if (id == R.id.Current_Matches) {
            CurrentMatches myFragment1=new CurrentMatches();
            fragmentTransaction.replace(R.id.content_main,myFragment1);
            fragmentTransaction.commit();


        } else if (id == R.id.Upcoming_Matches) {
            UpcomingMatches myFragment3=new UpcomingMatches();
            fragmentTransaction.replace(R.id.content_main,myFragment3);
            fragmentTransaction.commit();

        } else if (id == R.id.Recent_Results) {
           RecentResults myFragment4=new RecentResults();
            fragmentTransaction.replace(R.id.content_main,myFragment4);
            fragmentTransaction.commit();

        } else if (id == R.id.Player_Stats) {
            PlayerStats myFragment5=new PlayerStats();
            fragmentTransaction.replace(R.id.content_main,myFragment5);
            fragmentTransaction.commit();

        } else if (id == R.id.Series_Stats) {
            TeamStats myFragment6=new TeamStats();
            fragmentTransaction.replace(R.id.content_main,myFragment6);
            fragmentTransaction.commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;

    }
    DatabaseReference mRootName=mRef.child("cricit").child("news");
    final List<String> listinnews=new ArrayList<String>();


    private void populateListView(){
        String[] myitems={"1","2","3","4","5","6","7","8"};

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.daitems,myitems);

        ListView list1=(ListView) findViewById(R.id.lv2);
        ListView list2=(ListView) findViewById(R.id.lv1);
        list1.setAdapter(adapter);
        list2.setAdapter(adapter);

    }

    private void registerClickCallback(){
        list1=(ListView) findViewById(R.id.lv2);
        ListView lvTest = (ListView) findViewById(R.id.lv1);
        ValueEventListener valueEventListener=mRootName.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    listinnews.add(String.valueOf(dsp.getKey()));
                }
                System.out.println(listinnews);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,listinnews);

                list1.setAdapter(adapter);


            }



            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        list1.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                TextView textView=(TextView) viewClicked;
                String message="You Clicked #"+position+",which is string:"+textView.getText().toString();
                Toast.makeText(MainActivity.this,message,Toast.LENGTH_LONG).show();
            }
        });
    }

}
