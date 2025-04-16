package com.example.mywallpaper.Models;

import java.util.List;

public class CuretedApiResponse {
    private String nextPage;
    private long perPage;
    private long page;
    private List<Photo> photos;

    public String getNextPage() {
        return nextPage;
    }

    public void setNextPage(String value) {
        this.nextPage = value;
    }

    public long getPerPage() {
        return perPage;
    }

    public void setPerPage(long value) {
        this.perPage = value;
    }

    public long getPage() {
        return page;
    }

    public void setPage(long value) {
        this.page = value;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> value) {
        this.photos = value;
    }
}

