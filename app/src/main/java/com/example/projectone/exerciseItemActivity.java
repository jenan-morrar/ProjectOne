package com.example.projectone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.lights.LightsManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

import model.exercise;
import model.exerciseModel;

public class exerciseItemActivity extends AppCompatActivity {

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

    }
}