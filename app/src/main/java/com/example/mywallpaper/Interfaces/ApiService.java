package com.example.mywallpaper.Interfaces;

import com.example.mywallpaper.Models.CuretedApiResponse;
import com.example.mywallpaper.Models.SearchApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiService {
    @Headers({
            "Accept: application/json",
            "Authorization: EOLPqRBVoz2nqbucfkeHoSh27u0DmdYEJe5QfNuwJjeTzkkVF7ytU2X5"
    })
    @GET("curated/")
    Call<CuretedApiResponse> getWallpapers(
            @Query("page") String page,
            @Query("per_page") String per_page
    );

    @Headers({
            "Accept: application/json",
            "Authorization: EOLPqRBVoz2nqbucfkeHoSh27u0DmdYEJe5QfNuwJjeTzkkVF7ytU2X5"
    })
    @GET("search")
    Call<SearchApiResponse> searchWallpapers(
            @Query("query") String query,
            @Query("page") String page,
            @Query("per_page") String per_page
    );
}
