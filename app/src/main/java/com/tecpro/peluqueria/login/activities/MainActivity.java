package com.tecpro.peluqueria.login.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.tecpro.peluqueria.R;


public class MainActivity extends AppCompatActivity {

    TextView signin;
    TextView signup;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        signin = (TextView)findViewById(R.id.signin);
        signup = (TextView)findViewById(R.id.signup);


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(MainActivity.this,ActivitySignin.class);
                startActivity(it);
            }
        });


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(MainActivity.this,ActivitySignup.class);
                startActivity(it);

            }
        });
    }
}
