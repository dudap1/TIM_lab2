package com.example.dudap1_local.tim_lab2;


import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AvgServiceInterface {
    @GET("/Avg")
    Call<AvgObj> AvgResult(@Query(encoded = true, value = "array") ArrayList<Integer> arrayList);


}

