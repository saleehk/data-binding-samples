package com.saleeh.databinding.api;

import android.support.annotation.NonNull;

import java.io.File;

/**
 * @author Saleeh
 */
public class ClientConfig {
    private final File cacheDir;
    private final int cacheExpire;
    private final int cachedSize;

    /* package */ ClientConfig(@NonNull File cacheDir, int cacheExpire, @NonNull int cachedSize) {
        this.cacheDir = cacheDir;
        this.cacheExpire = cacheExpire;
        this.cachedSize = cachedSize;
    }

    public int getCacheExpire() {
        return cacheExpire;
    }

    public File getCacheDir() {
        return cacheDir;
    }

    public int getcachedSize() {
        return cachedSize;
    }

    public static class Builder {
        private File cacheDir;
        private int cacheExpire;
        private int cachedSize;


        public Builder() {
        }

        public
        @NonNull
        Builder setCacheDir(@NonNull File cacheDir) {
            this.cacheDir = cacheDir;
            return this;
        }

        public
        @NonNull
        Builder setcacheExpire(@NonNull int mCacheExpire) {
            cacheExpire = mCacheExpire;
            return this;
        }

        public
        @NonNull
        Builder
        setcachedSize(int cachedSize) {
            this.cachedSize = cachedSize;
            return this;
        }

        public
        @NonNull
        ClientConfig build() {
            validate();
            return new ClientConfig(cacheDir, cacheExpire, cachedSize);
        }

        /* package */ void validate() {

        }


    }
}
