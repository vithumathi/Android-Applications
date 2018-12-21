package com.mathiap.tones;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

                switch(item.getItemId()){
                    case R.id.now_playing:
                        Bundle data = getIntent().getExtras();
                        if (data != null){
                            NowPlayingFragment nowPlaying = new NowPlayingFragment();
                            nowPlaying.setArguments(data);
                            getSupportFragmentManager().beginTransaction().add(R.id.main_view, nowPlaying).commit();
                            drawer.closeDrawer(GravityCompat.START);
                        }else{
                            getSupportFragmentManager().beginTransaction().replace(R.id.main_view, new NowPlayingFragment()).commit();
                            drawer.closeDrawer(GravityCompat.START);
                        }

                        break;
                    case R.id.music_lib:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_view, new MyLibraryFragment()).commit();
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                }




                return true;
            }
        });

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.main_view, new NowPlayingFragment()).commit();
        }
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

}
