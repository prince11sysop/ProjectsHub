package com.appdeveloper.prince.projectshub;

public class BlogArt {
    private String image;
    private String title;

    public BlogArt() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BlogArt(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String title,String image) {
        this.image = image;
        this.title=title;
    }
}
