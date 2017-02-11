package com.tecpro.peluqueria.login.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.tecpro.peluqueria.R;
import com.tecpro.peluqueria.commons.MvpAbstractActivity;
import com.tecpro.peluqueria.home.Home;
import com.tecpro.peluqueria.login.presenters.SignInPresenter;
import com.tecpro.peluqueria.login.views.SignInView;

public class ActivitySignin extends MvpAbstractActivity<SignInView, SignInPresenter> implements SignInView {

    private EditText txtPass;
    private EditText txtUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);
        setupView();
    }

    @NonNull
    @Override
    public SignInPresenter createPresenter() {
        return new SignInPresenter();
    }

    @Override
    public String getId() {
        return null;
    }

    private void setupView() {
        final ImageView back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivitySignin.super.onBackPressed();
            }
        });

        final TextView signInButton = (TextView) findViewById(R.id.signin);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signin();
            }
        });
        txtPass = (EditText) findViewById(R.id.password);
        txtUsername = (EditText) findViewById(R.id.username);
    }


    private void signin() {
        presenter.signin();
    }


    @Override
    public String getUsername() {
        return txtUsername.getText().toString();
    }

    @Override
    public String getPassword() {
        return txtPass.getText().toString();
    }

    @Override
    public void goToHome() {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
}
