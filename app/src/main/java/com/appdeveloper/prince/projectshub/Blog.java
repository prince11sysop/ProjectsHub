package com.appdeveloper.prince.projectshub;

public class Blog {
    public String idea;
    public String ideaDescription;


    public  Blog()
    {}

    public String getIdea() {
        return idea;
    }

    public void setIdea(String idea) {
        this.idea = idea;
    }

    public String getIdeaDescription() {
        return ideaDescription;
    }

    public void setIdeaDescription(String ideaDescription) {
        this.ideaDescription = ideaDescription;
    }

    public Blog(String idea, String ideaDescription) {
        this.idea = idea;

        this.ideaDescription = ideaDescription;
    }
}
