package com.saleeh.databinding.api;

import android.app.Application;
import android.support.annotation.NonNull;


import com.saleeh.databinding.api.rest.RestAdapterFactory;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

/**
 * Singleton object to deal with APIService Web API and user authorization.
 * <p/>
 * First you need to initialize the singleton in your {@link Application}.
 * After the initialization, you can access the singleton instance via {@link ServiceApi.getInstance()}.
 * <p/>
 * Basic Usage:
 */
public class ServiceApi {
    public static final String TAG = ServiceApi.class.getSimpleName();
    private static volatile ServiceApi sSingleton;
    private final Application mApplication;
    private final ClientConfig mConfig;
    private final RestAdapterFactory mAdapterFactory;
    private APIService mAPIService;
    private APIService mCachedAPIService;

    /* package */ ServiceApi(Application application, ClientConfig config) {
        mApplication = application;
        mConfig = config;
        mAdapterFactory = new RestAdapterFactory(application, false);
    }

    /**
     * Initialize the singleton instance of this class.
     *
     * @param application the application.
     * @param config      your APIService API configuration.
     */
    public static void initialize(@NonNull Application application, @NonNull ClientConfig config) {
        if (sSingleton == null) {
            synchronized (ServiceApi.class) {
                if (sSingleton == null) {
                    sSingleton = new ServiceApi(application, config);
                }
            }
        }
    }

    public static synchronized ServiceApi getInstance() {
        if (sSingleton == null) {
            throw new IllegalStateException("APIService is not yet initialized.");
        }
        return sSingleton;
    }

    /**
     * Terminate singleton instance lifetime.
     */
    public static synchronized void destroy() {
        sSingleton = null;
    }

    /**
     * @return The APIService instance to access Web API
     */
    public synchronized APIService getApiService() {
        if (mAPIService == null) {
            RestAdapter adapter = mAdapterFactory.provideWebApiAdapter(new SimpleRequestInterceptor());
            mAPIService = adapter.create(APIService.class);
        }
        return mAPIService;
    }

    /**
     * @return The APIService instance to access cached Web API
     */
    public synchronized APIService getCachedApiService() {
        if (mCachedAPIService == null) {
            RestAdapter adapter = mAdapterFactory.provideCachedWebApiAdapter(new SimpleRequestInterceptorCache(), mConfig.getCacheDir(), mConfig.getcachedSize());
            mCachedAPIService = adapter.create(APIService.class);
        }
        return mCachedAPIService;
    }


    public ClientConfig getConfig() {
        return mConfig;
    }

    private class SimpleRequestInterceptorCache implements RequestInterceptor {
        @Override
        public void intercept(RequestFacade request) {
            request.addHeader("Cache-Control", "max-stale=" + mConfig.getCacheExpire());


        }
    }

    /**
     * The request interceptor that will add the header with OAuth
     * token to every request made with the wrapper.
     */
    private class SimpleRequestInterceptor implements RequestInterceptor {
        @Override
        public void intercept(RequestFacade request) {


        }
    }


}