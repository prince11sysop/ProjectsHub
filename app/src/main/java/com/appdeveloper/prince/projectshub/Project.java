package com.appdeveloper.prince.projectshub;

public class Project {
    private String title;
    private int image;

    public Project(String title,int image)
    {
        this.title=title;
        this.image=image;

    }

    public String getTitle()
    {
        return title;
    }
    public int getImage()
    {
        return image;
    }

    public Project()
    {
    }


}
