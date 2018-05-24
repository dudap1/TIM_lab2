package com.example.dudap1_local.tim_lab2;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RandomServiceInterface {

    @GET("/Random")
    Call<listObj> ListGenerate(@Query("count") String count);


}
