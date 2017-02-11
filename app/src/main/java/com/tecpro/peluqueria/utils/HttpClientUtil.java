package com.tecpro.peluqueria.utils;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by nico on 1/15/17.
 */

public class HttpClientUtil {

    private static OkHttpClient client;
    private static int timeout = 3;
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    public synchronized static OkHttpClient getClient(Context context) {

        if (client == null) {

            Log.i("HttpClientUtil", "new instance");
            client = new OkHttpClient();
            OkHttpClient.Builder builder = client.newBuilder();
            builder.connectTimeout(timeout, TimeUnit.SECONDS);
            builder.writeTimeout(timeout, TimeUnit.SECONDS);
            builder.readTimeout(timeout, TimeUnit.SECONDS);

            int cacheSize = 10 * 1024 * 1024; // 10 MiB
            Cache cache = new Cache(new File(context.getCacheDir().getPath() + "okhttp"), cacheSize);
            builder.cache(cache);
            //for debugging!!!
            final Interceptor logging = new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request();

                    long t1 = System.nanoTime();
                    Log.d("OKHTTP", String.format("Sending request %s on %s%n%s",
                            request.url(), chain.connection(), request.headers()));

                    Response response = chain.proceed(request);

                    long t2 = System.nanoTime();
                    Log.d("OKHTTP", String.format("Received response for %s in %.1fms%n%s",
                            response.request().url(), (t2 - t1) / 1e6d, response.headers()));

                    return response;
                }
            };
            builder.addInterceptor(logging);
            client = builder.build();
        }

        return client;
    }
}
