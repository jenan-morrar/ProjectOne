package com.example.projectone;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import model.User;

public class MainActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private User userLogin;
    private CheckBox rememberMe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.loginName);
        password = findViewById(R.id.loginPassword);
        rememberMe = findViewById(R.id.checkBox);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        Gson gson = new Gson();
        String str = prefs.getString("userSignUp", "");
        userLogin = gson.fromJson(str, User.class);


        rememberMe.setChecked(getSharedPreferences("MyAPP", Context.MODE_PRIVATE).getBoolean("checkBox", true));
        rememberMe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                getSharedPreferences("MyAPP", Context.MODE_PRIVATE).edit().putBoolean("checkBox", isChecked).commit();
            }
        });

        if(rememberMe.isChecked()) {
            if(userLogin != null){
                username.setText(userLogin.getUserName());
                password.setText(userLogin.getPassword());
            }
        }
    }

    public void login(View view) {

        String nameString = username.getText().toString();
        String passwordString = password.getText().toString();

        if(userLogin != null) {
            if (nameString.equals(userLogin.getUserName()) && passwordString.equals(userLogin.getPassword())) {
                Intent intent1 = new Intent(this, HomeActivity.class);
                intent1.putExtra("userNameData", nameString);
                startActivity(intent1);
            } else {
                Toast.makeText(MainActivity.this, "Error, Please Enter correct Username and Password!", Toast.LENGTH_LONG).show();
            }
        }else {
            Toast.makeText(MainActivity.this, "Please Sign Up First!", Toast.LENGTH_LONG).show();
        }
    }
    public void signUp (View view){
        Intent intent2 = new Intent(this, SignUpActivity.class);
        startActivity(intent2);
    }
}