package com.tecpro.peluqueria.commons;

import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by nico on 1/15/17.
 */

public interface MvpViewTP extends MvpView {

    // Shows the login form
    void showRegular();

    // Called if username / password is incorrect
    void showError();

    // Shows a loading animation while checking auth credentials
    void showLoading();

}
