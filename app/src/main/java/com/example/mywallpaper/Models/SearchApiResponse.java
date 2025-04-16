// SearchApiResponse.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

package com.example.mywallpaper.Models;
import java.util.List;

public class SearchApiResponse {
    private String nextPage;
    private long perPage;
    private long page;
    private List<Photo> photos;
    private long totalResults;

    public String getNextPage() { return nextPage; }
    public void setNextPage(String value) { this.nextPage = value; }

    public long getPerPage() { return perPage; }
    public void setPerPage(long value) { this.perPage = value; }

    public long getPage() { return page; }
    public void setPage(long value) { this.page = value; }

    public List<Photo> getPhotos() { return photos; }
    public void setPhotos(List<Photo> value) { this.photos = value; }

    public long getTotalResults() { return totalResults; }
    public void setTotalResults(long value) { this.totalResults = value; }
}

// Photo.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

// Src.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

