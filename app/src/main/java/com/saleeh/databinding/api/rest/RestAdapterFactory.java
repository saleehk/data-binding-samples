package com.saleeh.databinding.api.rest;

import android.app.Application;
import android.util.Log;

import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;

import java.io.File;
import java.util.concurrent.TimeUnit;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * @author Saleeh
 */
public class RestAdapterFactory {
    public static final String TAG = RestAdapterFactory.class.getSimpleName();
    public static final String WEB_API_ENDPOINT = "https://api.github.com/";
    private final OkClient mOkClient;

    public RestAdapterFactory(Application application, boolean cache) {
        OkHttpClient ok = new OkHttpClient();
        if (cache) {
            try {
                int cacheSize = 10 * 1024 * 1024; // 10 MiB
                Cache responseCache = new Cache(application.getCacheDir(), cacheSize);
                ok.setCache(responseCache);
            } catch (Exception e) {
                Log.d(TAG, "Unable to set http cache", e);
            }
            ok.setReadTimeout(30, TimeUnit.SECONDS);
            ok.setConnectTimeout(30, TimeUnit.SECONDS);
        }
        mOkClient = new OkClient(ok);
    }

    public RestAdapter provideWebApiAdapter(RequestInterceptor interceptor) {
        return new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setClient(mOkClient)
                .setEndpoint(WEB_API_ENDPOINT)
                .setRequestInterceptor(interceptor)
                .build();
    }

    public RestAdapter provideCachedWebApiAdapter(RequestInterceptor interceptor, File cacheDir, int cacheSize) {
        OkHttpClient ok = new OkHttpClient();
        try {
            //int cacheSize = 10 * 1024 * 1024; // 10 MiB
            Cache responseCache = new Cache(cacheDir, cacheSize);
            ok.setCache(responseCache);
        } catch (Exception e) {
            Log.d(TAG, "Unable to set http cache", e);
        }
        ok.setReadTimeout(30, TimeUnit.SECONDS);
        ok.setConnectTimeout(30, TimeUnit.SECONDS);


        return new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setClient(new OkClient(ok))
                .setEndpoint(WEB_API_ENDPOINT)
                .setRequestInterceptor(interceptor)
                .build();
    }


}
