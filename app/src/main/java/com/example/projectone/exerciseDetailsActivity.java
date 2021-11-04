package com.example.projectone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

import model.exercise;
import model.exerciseModel;
import pl.droidsonroids.gif.GifImageView;

public class exerciseDetailsActivity extends AppCompatActivity {

    public TextView textView;
    public GifImageView gifImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_details);

        Intent intent = getIntent();
        String exerciseId = intent.getStringExtra("Data");

        exerciseModel model = new exerciseModel();
        ArrayList<exercise> exercises = model.getExercises();

        textView =findViewById(R.id.exerciseId);
        textView.setText(exerciseId);
        gifImageView =findViewById(R.id.exerciseImage);


        for(int i=0; i<exercises.size(); i++){
            if(exercises.get(i).getId().equals(exerciseId)){
                gifImageView.setImageResource(exercises.get(i).getImage());
            }
        }
    }
}