package com.tecpro.peluqueria.login.views;

import com.tecpro.peluqueria.commons.MvpViewTP;


public interface SignInView extends MvpViewTP {

    String getId();

    String getUsername();
    String getPassword();
    void goToHome();
}