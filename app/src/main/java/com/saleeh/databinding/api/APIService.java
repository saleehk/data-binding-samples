package com.saleeh.databinding.api;



import com.saleeh.databinding.api.models.Repo;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

public interface APIService {
    public int time = 640000;

    /**
     * Events *
     */


    @GET("/repositories")
    public void getRepositories(Callback<List<Repo>> callback);

    @GET("/users/{user}/repos")

    public void getReposByUser(@Path("user") String user, Callback<List<Repo>> callback);
}
