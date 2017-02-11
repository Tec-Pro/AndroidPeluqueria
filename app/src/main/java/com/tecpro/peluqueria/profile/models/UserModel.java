package com.tecpro.peluqueria.profile.models;

import com.tecpro.peluqueria.profile.dto.User;
import com.tecpro.peluqueria.profile.interfaces.UserApi;
import com.tecpro.peluqueria.utils.RestAdapter;

import rx.Observable;

/**
 * Created by nico on 1/15/17.
 */

public class UserModel {

    private final UserApi userApi = RestAdapter.getInstance().getRestAdapter().create(UserApi.class);

    public Observable<User> getUser(final String id){
        return userApi.findUserById(id);
    }
}
