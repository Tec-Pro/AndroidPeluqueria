package com.tecpro.peluqueria.utils;

import android.support.annotation.NonNull;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nico on 1/15/17.
 */

public final class RestAdapter {


    private static RestAdapter instance;
    private static boolean isStarted = false;
    private static Retrofit restAdapter;

    private RestAdapter() {
    }

    public Retrofit getRestAdapter() {
        if (!isStarted) {
            throw new IllegalStateException("error get adapter");
        }
        return restAdapter;
    }

    public static synchronized RestAdapter getInstance() {
        if (instance == null) {
            instance = new RestAdapter();
        }
        return instance;
    }

    public synchronized void start(@NonNull final GsonConverterFactory gsonConverterFactory,
                                   @NonNull final List<CallAdapter.Factory> factories,
                                   @NonNull final String endpoint, @NonNull final OkHttpClient client) {

        final Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(endpoint)
                .client(client)
                .addConverterFactory(gsonConverterFactory);
        for (final CallAdapter.Factory factory : factories) {
            builder.addCallAdapterFactory(factory);
        }

        restAdapter = builder.build();

        isStarted = true;
    }
}
