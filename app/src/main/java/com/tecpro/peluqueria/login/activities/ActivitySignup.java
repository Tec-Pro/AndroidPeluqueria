package com.tecpro.peluqueria.login.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.tecpro.peluqueria.R;
import com.tecpro.peluqueria.commons.MvpAbstractActivity;
import com.tecpro.peluqueria.login.presenters.SignUpPresenter;
import com.tecpro.peluqueria.login.views.SignUpView;

public class ActivitySignup extends MvpAbstractActivity<SignUpView, SignUpPresenter> implements SignUpView {


    private EditText txtEmail;
    private EditText txtPass;
    private EditText txtUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        setupView();

    }

    private void setupView(){
        final ImageView back = (ImageView)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivitySignup.super.onBackPressed();
            }
        });

        final TextView signInButton = (TextView) findViewById(R.id.signin);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signup();
            }
        });
        txtPass = (EditText) findViewById(R.id.password);
        txtEmail =(EditText) findViewById(R.id.email);
        txtUsername =(EditText) findViewById(R.id.username);
    }

    private void signup(){
       presenter.signup();
    }

    @NonNull
    @Override
    public SignUpPresenter createPresenter() {
        return new SignUpPresenter();
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public String getUsername() {
        return txtUsername.getText().toString() ;
    }

    @Override
    public String getPassword() {
        return txtPass.getText().toString() ;
    }

    @Override
    public String getPhone() {
        return txtEmail.getText().toString() ;
    }
}
