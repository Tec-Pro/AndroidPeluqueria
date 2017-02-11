package com.tecpro.peluqueria.profile.activities;

import android.app.Application;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.tecpro.peluqueria.utils.HttpClientUtil;
import com.tecpro.peluqueria.utils.RestAdapter;

import java.util.ArrayList;

import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

/**
 * Created by nico on 1/15/17.
 */

public class MainApplication extends Application {

    @Override
    public void onCreate() {

        super.onCreate();

        RestAdapter.getInstance().start(getGsonConverterFactory(),
                new ArrayList<CallAdapter.Factory>() {{
                    add(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()));
                }},
                "https://private-036fb2-reservationsapp.apiary-mock.com",
                HttpClientUtil.getClient(this)
        );


    }

    private GsonConverterFactory getGsonConverterFactory() {
        return GsonConverterFactory.create(new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").create());
    }
}
