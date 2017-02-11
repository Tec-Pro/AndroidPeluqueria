package com.tecpro.peluqueria.login.models;

import com.tecpro.peluqueria.login.interfaces.LoginApi;
import com.tecpro.peluqueria.profile.dto.User;
import com.tecpro.peluqueria.utils.RestAdapter;

import rx.Observable;

/**
 * Created by nico on 1/15/17.
 */

public class LoginModel {

    private final LoginApi userApi = RestAdapter.getInstance().getRestAdapter().create(LoginApi.class);

    public Observable<User> signup(final User user){
        return userApi.signup(user);
    }

    public Observable<User> signin(final User user){
        return userApi.signin(user);
    }
}
