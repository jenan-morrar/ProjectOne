package com.example.projectone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.loginName);
        password = findViewById(R.id.loginPassword);
    }

    public void login(View view) {

        String nameString = username.getText().toString();
        String passwordString = password.getText().toString();
        if(nameString.equals("ahmad") && passwordString.equals("123")){
            Intent intent1 = new Intent(this, HomeActivity.class);
            intent1.putExtra("userNameData", nameString);
            intent1.putExtra("userPasswordData", passwordString);
            startActivity(intent1);
        }else {
            Toast.makeText(MainActivity.this,"Error, Please Enter correct Password and username!", Toast.LENGTH_LONG).show();
        }


    }
    public void signUp (View view){
        Intent intent2 = new Intent(this, SignUpActivity.class);
        startActivity(intent2);
    }
}