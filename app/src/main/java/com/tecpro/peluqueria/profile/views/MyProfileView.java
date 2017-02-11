package com.tecpro.peluqueria.profile.views;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;
import com.tecpro.peluqueria.commons.MvpViewTP;
import com.tecpro.peluqueria.profile.dto.User;

/**
 * Created by nico on 1/14/17.
 */

public interface MyProfileView extends MvpViewTP {

    String getId();

    void showData(final User user);
}