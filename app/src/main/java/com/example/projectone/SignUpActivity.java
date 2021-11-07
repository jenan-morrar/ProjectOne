package com.example.projectone;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import model.User;

public class SignUpActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private EditText email;
    private EditText age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username = findViewById(R.id.signUpName);
        password = findViewById(R.id.signUpPassword);
        email = findViewById(R.id.signUpEmail);
        age =findViewById(R.id.signUpAge);
    }

    public void signUpUser (View view){

        String name = username.getText().toString();
        String passwordString = password.getText().toString();
        String genderString = email.getText().toString();
        int ageString = Integer.parseInt(age.getText().toString());
        User user = new User(name, passwordString, genderString, ageString);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String userString = gson.toJson(user);

        editor.putString("userSignUp", userString);
        editor.commit();

        Toast.makeText(SignUpActivity.this,"You are successfully signed up", Toast.LENGTH_LONG).show();
    }

    public void bakeToLogin (View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}