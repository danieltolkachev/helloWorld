package de.htw.webtech.hello.webtech.web.api;


public class TaskManipulationRequest {
    private String title;
    private String description;
    private Boolean favorite;

    public TaskManipulationRequest() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }
}