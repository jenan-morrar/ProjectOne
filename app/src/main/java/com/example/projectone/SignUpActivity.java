package com.example.projectone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import model.User;
import model.UserModel;

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
        UserModel userModel = new UserModel();
        ArrayList<User> users = userModel.getUsers();
        users.add(new User(name, passwordString, genderString, ageString));

        Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
        startActivity(intent);

        Toast.makeText(SignUpActivity.this,"You are successfully signed up", Toast.LENGTH_SHORT).show();
    }

    public void bakeToLogin (View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}