package com.tecpro.peluqueria.login.views;

import com.tecpro.peluqueria.commons.MvpViewTP;


public interface SignUpView extends MvpViewTP {

    String getId();

    String getUsername();
    String getPassword();
    String getPhone();
}