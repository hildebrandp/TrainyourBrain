package com.schisskiss.trainyourbrain;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Boolean doubleBackToExitPressedOnce = false;

    /** -------------------- Shared Preferences -------------------- */
    private SharedPreferences sharedPreferences = null;
    private String mySharedPreferences = "myPreferences";

    private String sharedUserLogin = "userLogin";
    private String sharedUserName = "userName";
    private String sharedUserMail = "userMail";
    private String sharedUserPass = "userPass";

    /** -------------------- Layout Resources -------------------- */
    private TextView textView_userName;
    private TextView textView_userMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View headerView = navigationView.getHeaderView(0);

        textView_userName = headerView.findViewById(R.id.userNameTextView);
        textView_userMail = headerView.findViewById(R.id.userMailTextView);

        sharedPreferences = getSharedPreferences(mySharedPreferences, Context.MODE_PRIVATE);

        if (sharedPreferences.getBoolean("settingsFirstRun", true)) {
            //Implement window for question if user wants to create account/login
            Toast.makeText(this, "First login", Toast.LENGTH_SHORT).show();

            sharedPreferences.edit().putBoolean("settingsFirstRun", false).apply();
        }

        if (!sharedPreferences.getBoolean(sharedUserLogin, false)) {
            textView_userName.setText(R.string.defaultUserName);
            textView_userMail.setText(R.string.defaultUserMail);
        } else {
            textView_userName.setText(sharedPreferences.getString(sharedUserName, "Error"));
            textView_userMail.setText(sharedPreferences.getString(sharedUserMail, "Error"));
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
            }

            doubleBackToExitPressedOnce = true;
            Toast.makeText(this, R.string.action_pressToExit, Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.my_Records) {
            // Handle the camera action
        } else if (id == R.id.world_Records) {

        } else if (id == R.id.game_1) {

        } else if (id == R.id.game_2) {

        } else if (id == R.id.game_3) {

        } else if (id == R.id.game_4) {

        } else if (id == R.id.settings_login) {

        } else if (id == R.id.settings_account) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
