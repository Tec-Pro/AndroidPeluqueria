package com.tecpro.peluqueria.login.interfaces;

import com.tecpro.peluqueria.profile.dto.User;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by nico on 1/14/17.
 */

public interface LoginApi {

    @POST("/users")
    Observable<User> signin(@Body User user);

    @POST("/users/login")
    Observable<User> signup(@Body User user);
}
