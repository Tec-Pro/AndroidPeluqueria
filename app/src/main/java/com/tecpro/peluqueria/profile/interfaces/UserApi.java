package com.tecpro.peluqueria.profile.interfaces;

import com.tecpro.peluqueria.profile.dto.User;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by nico on 1/14/17.
 */

public interface UserApi {

    @GET("/users/{id}")
    Observable<User> findUserById(@Path("id") String id);
}
