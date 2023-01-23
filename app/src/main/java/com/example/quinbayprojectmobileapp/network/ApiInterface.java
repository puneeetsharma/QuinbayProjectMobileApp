package com.example.quinbayprojectmobileapp.network;

import com.example.quinbayprojectmobileapp.model.Products;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("backend/search/products")
    Call<Products> getProducts(@Query("searchTerm") String searchTerm,@Query("page") int page,
                               @Query("start") int start);
}
