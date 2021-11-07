package com.example.projectone;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import model.exercise;
import model.exerciseModel;

public class exerciseItemActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    public ListView listView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_item);

        Intent intent = getIntent();
        String day = intent.getStringExtra("Data");

        exerciseModel model = new exerciseModel();
        ArrayList<exercise> exercisesList = model.getExercises();
        ArrayList<String> itemIds = new ArrayList<String>();

        for (int i =0 ;i<exercisesList.size();i++ ){
            if(exercisesList.get(i).getDay().equals(day)){
                itemIds.add(exercisesList.get(i).getId());
            }
        }
        listView = findViewById(R.id.exerciseItemListview);
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, itemIds);
         listView.setAdapter(adapter);

        // List View Items:
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent = null;
                String selectedItem = (String) parent.getItemAtPosition(position);
                intent = new Intent(getApplicationContext(), exerciseDetailsActivity.class);
                intent.putExtra("Data", selectedItem);

                if(intent != null){
                    startActivity(intent);
                }
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
                R.string.openNavDrawer,
                R.string.closeNavDrawer
        );
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case  R.id.ic_home:
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                overridePendingTransition(0,0);
            case R.id.ic_sport:
                startActivity(new Intent(getApplicationContext(), ExercisesActivity.class));
                overridePendingTransition(0,0);
                return true;
            case R.id.ic_favourite:
                startActivity(new Intent(getApplicationContext(), FavouriteActivity.class));
                overridePendingTransition(0,0);
                return true;
            case R.id.ic_logout:
                AlertDialog.Builder builder = new AlertDialog.Builder(exerciseItemActivity.this);
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