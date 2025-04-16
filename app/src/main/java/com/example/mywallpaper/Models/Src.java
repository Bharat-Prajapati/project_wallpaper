package com.example.mywallpaper.Models;

import java.io.Serializable;

public class Src implements Serializable {
    private String small;
    private String original;
    private String large;
    private String tiny;
    private String medium;
    private String large2X;
    private String portrait;
    private String landscape;

    public String getSmall() { return small; }
    public void setSmall(String value) { this.small = value; }

    public String getOriginal() { return original; }
    public void setOriginal(String value) { this.original = value; }

    public String getLarge() { return large; }
    public void setLarge(String value) { this.large = value; }

    public String getTiny() { return tiny; }
    public void setTiny(String value) { this.tiny = value; }

    public String getMedium() { return medium; }
    public void setMedium(String value) { this.medium = value; }

    public String getLarge2X() { return large2X; }
    public void setLarge2X(String value) { this.large2X = value; }

    public String getPortrait() { return portrait; }
    public void setPortrait(String value) { this.portrait = value; }

    public String getLandscape() { return landscape; }
    public void setLandscape(String value) { this.landscape = value; }
}
