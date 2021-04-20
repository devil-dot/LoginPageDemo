package com.kmtstudio.loginpagedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText userName,passWord;
    private Button loginBtn;
    private TextView textView;
    private int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        userName = findViewById(R.id.userID);
        passWord = findViewById(R.id.passID);

        loginBtn = findViewById(R.id.logInBtnID);

        textView = findViewById(R.id.txtViewID);

        textView.setText("Number of attempts remaining : 3");


        loginBtn.setOnClickListener(v -> {

            String name = userName.getText().toString();
            String pass = passWord.getText().toString();

            if (name.equals("admin") && pass.equals("123")) {

                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);

            } else {

                counter--;
                textView.setText("Number of attempts remaining : "+counter);

            } if (counter==0) {

                loginBtn.setEnabled(false);
            }

        });
    }
}