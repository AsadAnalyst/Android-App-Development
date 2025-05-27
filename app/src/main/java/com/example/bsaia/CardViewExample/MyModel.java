package com.example.bsaia.CardViewExample;

public class MyModel {
    public String Name;
    public int TotalDownload;
    public int Thumbnail;
    //alt+inser

    public MyModel(String name, int totalDownload, int thumbnail) {
        Name = name;
        TotalDownload = totalDownload;
        Thumbnail = thumbnail;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getTotalDownload() {
        return TotalDownload;
    }

    public void setTotalDownload(int totalDownload) {
        TotalDownload = totalDownload;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }
}
