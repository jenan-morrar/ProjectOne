package com.example.projectone;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Locale;

import model.exercise;
import model.exerciseModel;
import pl.droidsonroids.gif.GifImageView;

public class exerciseDetailsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final long START_TIME_IN_MILLIS = 600000;
    //public TextView textView;
    public GifImageView gifImageView;
    private TextView mTextViewCountDown;
    private Button mButtonStartPause;
    private Button mButtonReset;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private exerciseModel model = new exerciseModel();
    private ArrayList<exercise> exercises = model.getExercises();
    private String exerciseId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_details);

        Intent intent = getIntent();
        exerciseId = intent.getStringExtra("Data");

        gifImageView =findViewById(R.id.exerciseImage);

        for(int i=0; i<exercises.size(); i++){
            if(exercises.get(i).getId().equals(exerciseId)){
                gifImageView.setImageResource(exercises.get(i).getImage());
            }
        }

        mTextViewCountDown = findViewById(R.id.text_view_countdown);

        mButtonStartPause = findViewById(R.id.button_start_pause);
        mButtonReset = findViewById(R.id.button_reset);

        mButtonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTimerRunning) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });

        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });

        Thread thread = new Thread(new MyTask());
        thread.start();

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

    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                Thread thread = new Thread(new MyTask());
                thread.start();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                mButtonStartPause.setText("Start");
                mButtonStartPause.setVisibility(View.INVISIBLE);
                mButtonReset.setVisibility(View.VISIBLE);
            }
        }.start();

        mTimerRunning = true;
        mButtonStartPause.setText("pause");
        mButtonReset.setVisibility(View.INVISIBLE);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(exerciseDetailsActivity.this);
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

    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;
        mButtonStartPause.setText("Start");
        mButtonReset.setVisibility(View.VISIBLE);
    }

    private void resetTimer() {
        mTimeLeftInMillis = START_TIME_IN_MILLIS;
        //updateCountDownText();
        Thread thread = new Thread(new MyTask());
        thread.start();
        mButtonReset.setVisibility(View.INVISIBLE);
        mButtonStartPause.setVisibility(View.VISIBLE);
    }

    public void addFavourite(View view) {

        String excDay = "";
        String excDic = "";
        int excImg =0;

        for(int i=0; i<exercises.size(); i++){
            if(exercises.get(i).getId().equals(exerciseId)){
                excDay = exercises.get(i).getDay();
                excDic = exercises.get(i).getDescription();
                excImg = exercises.get(i).getImage();
            }
        }
        exercise exerciseObject = new exercise(exerciseId,excDay,excDic,excImg);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String userFavouriteString = gson.toJson(exerciseObject);

        editor.putString("userFavourite", userFavouriteString);
        editor.commit();

        Toast.makeText(exerciseDetailsActivity.this,"added successfully", Toast.LENGTH_LONG).show();
    }

    class MyTask implements Runnable{
        public MyTask(){
        }
        @Override
        public void run() {

            int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
            int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

            String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

            mTextViewCountDown.post(new Runnable() {
                @Override
                public void run() {
                    mTextViewCountDown.setText(timeLeftFormatted);
                }
            });
        }
    }

}