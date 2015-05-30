package com.saleeh.databinding;

import android.app.Application;

import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.utils.StorageUtils;
import com.saleeh.databinding.api.ClientConfig;
import com.saleeh.databinding.api.ServiceApi;

import java.io.File;

/**
 * Created by saleeh on 02/02/15.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ServiceApi.initialize(this,
                new ClientConfig.Builder()
                        .setCacheDir(getCacheDir())
                        .setcachedSize(10 * 1024 * 1024)
                        .setcacheExpire(60 * 60 * 24 * 28)
                        .build()
        );
        File cacheDir = StorageUtils.getCacheDirectory(getApplicationContext(), true);
        ImageLoaderConfiguration localImageLoaderConfiguration =
                new ImageLoaderConfiguration.Builder(
                        getApplicationContext()).defaultDisplayImageOptions(
                        new DisplayImageOptions.Builder()
                                .showImageOnLoading(R.mipmap.ic_launcher)
                                .showImageOnLoading(R.mipmap.ic_launcher)
                                .showImageOnFail(R.mipmap.ic_launcher)
                                .cacheInMemory(true)
                                .cacheOnDisk(true)
                                .considerExifParams(true)
                                .displayer(new FadeInBitmapDisplayer(500))
                                .build())
                        .tasksProcessingOrder(QueueProcessingType.LIFO)
                        .memoryCache(new WeakMemoryCache())

                        .diskCacheSize(50 * 1024 * 1024)
                        .diskCacheFileCount(100)
                        .diskCacheFileNameGenerator(new HashCodeFileNameGenerator()) // default
                        .build();


        ImageLoader.getInstance().init(localImageLoaderConfiguration);
    }
}
