package com.example.harsh.mp3;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;


public class Player_Details extends AppCompatActivity {



    /**

     * The {@link android.support.v4.view.PagerAdapter} that will provide

     * fragments for each of the sections. We use a

     * {@link FragmentPagerAdapter} derivative, which will keep every

     * loaded fragment in memory. If this becomes too memory intensive, it

     * may be best to switch to a

     * {@link android.support.v4.app.FragmentStatePagerAdapter}.

     */



    /**

     * The {@link ViewPager} that will host the section contents.

     */





    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Log.d("kkkk","llll");
        setContentView(R.layout.activity_player__details);



        Toolbar toolbar;



        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PlayerStatesPlayers.class);
                startActivity(intent);
                Player_Details.this.finish();
            }
        });

        getSupportActionBar().setTitle("Main Menu");

        // Create the adapter that will return a fragment for each of the three

        // primary sections of the activity.



        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        tabLayout.addTab(tabLayout.newTab().setText("Bio"));

        tabLayout.addTab(tabLayout.newTab().setText("Batting"));
        tabLayout.addTab(tabLayout.newTab().setText("Bowling"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);



        final ViewPager viewPager = (ViewPager) findViewById(R.id.container);

        final PagerAdapter adapter = new PagerAdapter

                (getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override

            public void onTabSelected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());

            }



            @Override

            public void onTabUnselected(TabLayout.Tab tab) {



            }



            @Override

            public void onTabReselected(TabLayout.Tab tab) {



            }

        });

    }





    @Override

    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu_player__details, menu);

        return true;

    }




    /**

     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to

     * one of the sections/tabs/pages.

     */

    public class PagerAdapter extends FragmentStatePagerAdapter {



        int mNumOfTabs;

        public PagerAdapter(FragmentManager fm, int NumOfTabs) {

            super(fm);

            this.mNumOfTabs = NumOfTabs;

        }



        @Override

        public Fragment getItem(int position) {

            // getItem is called to instantiate the fragment for the given page.

            // Return a PlaceholderFragment (defined as a static inner class below).

            switch (position) {

                case 0 :

                    tab1bio tab1 = new tab1bio();

                    return tab1;

                case 1:

                    tab2batting tab2 = new tab2batting();

                    return tab2;
                case 2 :

                    tab3bowling tab3 = new tab3bowling();

                    return tab3;



                default:

                    return null;

            }

        }





        @Override

        public int getCount() {

            // Show 3 total pages.



            return mNumOfTabs;

        }



    }







}