package com.example.mywallpaper.Interfaces;

import com.example.mywallpaper.Models.SearchApiResponse;

public interface SearchWallpaperListener {
    void onSuccess(SearchApiResponse response, String message);
    void onFailure(String message);
}
