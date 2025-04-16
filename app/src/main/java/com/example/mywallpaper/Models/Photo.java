package com.example.mywallpaper.Models;

import java.io.Serializable;

public class Photo implements Serializable {
    private Src src;
    private long width;
    private String avgColor;
    private String alt;
    private String photographer;
    private String photographerurl;
    private long id;
    private String url;
    private long photographerid;
    private boolean liked;
    private long height;

    public Src getSrc() { return src; }
    public void setSrc(Src value) { this.src = value; }

    public long getWidth() { return width; }
    public void setWidth(long value) { this.width = value; }

    public String getAvgColor() { return avgColor; }
    public void setAvgColor(String value) { this.avgColor = value; }

    public String getAlt() { return alt; }
    public void setAlt(String value) { this.alt = value; }

    public String getPhotographer() { return photographer; }
    public void setPhotographer(String value) { this.photographer = value; }

    public String getPhotographerurl() { return photographerurl; }
    public void setPhotographerurl(String value) { this.photographerurl = value; }

    public long getid() { return id; }
    public void setid(long value) { this.id = value; }

    public String geturl() { return url; }
    public void seturl(String value) { this.url = value; }

    public long getPhotographerid() { return photographerid; }
    public void setPhotographerid(long value) { this.photographerid = value; }

    public boolean getLiked() { return liked; }
    public void setLiked(boolean value) { this.liked = value; }

    public long getHeight() { return height; }
    public void setHeight(long value) { this.height = value; }
}

