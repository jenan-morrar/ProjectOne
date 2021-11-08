package com.example.projectone;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Spinner spinner;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        textView =findViewById(R.id.homeInfo);
        spinner = findViewById(R.id.spinner);
        ArrayList<String> items = new ArrayList<>();
        items.add("About App");
        items.add("Contact Us");
        items.add("Tips");

        ArrayAdapter<String> adp = new ArrayAdapter<String> (this,android.R.layout.simple_spinner_dropdown_item,items);
        spinner.setAdapter(adp);
        spinner.setVisibility(View.VISIBLE);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long arg3)
            {
                if(parent.getItemAtPosition(position).toString().equals("About App")){
                    textView.setText("This app aims to fit the fat, where it helps to reduce weight, build body muscles and burn fat, in addition to tightening fat sagging.\n" +
                            "Where the exercises in this application have been divided into warm-up exercises, muscle relaxation exercises, abdominal exercises, exercises to build shoulder muscles, and there are exercises to burn thigh fat, as the duration of each exercise is approximately 5-6 minutes per day, so that I this system helps The body adapts to exercise and gradually begins to lose weight.");

                }else if (parent.getItemAtPosition(position).toString().equals("Contact Us")){
                    textView.setText("You can Contact with us by: "+"\n"+"Telephone: 02-223-453"+"\n"+"Phone:059-999-889-899"+"\n"+"Email: Fitfat@yahoo.com"+"\n"+"Facebook: www.facebook.Fit the fat");
                }else if (parent.getItemAtPosition(position).toString().equals("Tips")){
                    textView.setText("Note: All the exercises in this application have been practiced before and research has been done about the consequences thereof, as these exercises do not pose a danger to anyone, but it should be careful while doing these exercises, in addition to that he likes to do warm-up exercises before starting any of the stretching exercises or Build muscle as this may cause muscle strain resulting in muscle tear");
                }
            }
            public void onNothingSelected(AdapterView<?> arg0)
            {
            }
        });

        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.nav_open,
                R.string.nav_close
        );
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case  R.id.ic_home:
                return true;
            case R.id.ic_sport:
                startActivity(new Intent(getApplicationContext(), ExercisesActivity.class));
                overridePendingTransition(0,0);
                return true;
            case R.id.ic_favourite:
                startActivity(new Intent(getApplicationContext(), FavouriteActivity.class));
                overridePendingTransition(0,0);
                return true;
            case R.id.ic_logout:
                AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
                builder.setTitle("Confirmation message");
                builder.setMessage("Do you want to logout from the application ?");
                builder.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AlertDialog dialog = builder.show();
        }
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}