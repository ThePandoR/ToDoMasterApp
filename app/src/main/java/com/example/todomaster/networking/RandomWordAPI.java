package com.example.todomaster.networking;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RandomWordAPI {

    @GET("word?swear=0")
    Call<String[]> getWord(@Query("number") int n);
}
