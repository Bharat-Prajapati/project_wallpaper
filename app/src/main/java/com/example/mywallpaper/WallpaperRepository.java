package com.example.mywallpaper;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.mywallpaper.Interfaces.ApiService;
import com.example.mywallpaper.Interfaces.CuratedWallpaperListener;
import com.example.mywallpaper.Interfaces.SearchWallpaperListener;
import com.example.mywallpaper.Models.CuretedApiResponse;
import com.example.mywallpaper.Models.SearchApiResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WallpaperRepository {

    private final Context context;

    public WallpaperRepository(Context context) {
        this.context = context;
    }

    public void getCuratedWallpapers(CuratedWallpaperListener listener, String page, String per_page){
        ApiService apiService = RetrofitInstance.getInstance().create(ApiService.class);

        apiService.getWallpapers(page, per_page).enqueue(new Callback<CuretedApiResponse>() {
            @Override
            public void onResponse(@NonNull Call<CuretedApiResponse> call, @NonNull Response<CuretedApiResponse> response) {
                if (response.isSuccessful()) {
//                    Toast.makeText(context, "", Toast.LENGTH_SHORT).show();
                    listener.onSuccess(response.body(), response.message());
                }
                else {
                    Toast.makeText(context, "An error occurred", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<CuretedApiResponse> call, @NonNull Throwable throwable) {
                listener.onFailure(throwable.getMessage());
            }
        });
    }


    public void getSearchWallpapers(SearchWallpaperListener listener, String page, String per_page, String query){
        ApiService apiService = RetrofitInstance.getInstance().create(ApiService.class);

        apiService.searchWallpapers(query, page, per_page).enqueue(new Callback<SearchApiResponse>() {
            @Override
            public void onResponse(Call<SearchApiResponse> call, Response<SearchApiResponse> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response.body(), response.message());
                }
                else {
                    Toast.makeText(context, "An error occurred", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SearchApiResponse> call, Throwable throwable) {
                listener.onFailure(throwable.getMessage());
            }
        });
    }

}
