package de.htw.webtech.hello.webtech.web.api;



import java.time.LocalDate;

public class ToDoManipulationRequest {
    private String titel;
    private String description;
    private LocalDate date;
    private Boolean finished;
    private Boolean favorite;

    public ToDoManipulationRequest() {
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {

        this.titel = titel;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }
}