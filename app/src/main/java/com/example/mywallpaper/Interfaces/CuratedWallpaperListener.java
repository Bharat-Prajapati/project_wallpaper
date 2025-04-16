package com.example.mywallpaper.Interfaces;

import com.example.mywallpaper.Models.CuretedApiResponse;

public interface CuratedWallpaperListener {
    void onSuccess(CuretedApiResponse response, String message);
    void onFailure(String message);
}
