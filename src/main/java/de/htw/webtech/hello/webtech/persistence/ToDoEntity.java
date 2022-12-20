package de.htw.webtech.hello.webtech.persistence;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "toDos")
public class ToDoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "titel", nullable = false)
    private String titel;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "is_finished")
    private Boolean finished;

    @Column(name = "is_favorite")
    private Boolean favorite;

    public ToDoEntity(String titel, String description, LocalDate date, Boolean finished, Boolean favorite) {

        this.titel = titel;
        this.description = description;
        this.date = date;
        this.finished = finished;
        this.favorite = favorite;
    }

    protected ToDoEntity() {    }

    public Long getId() {
        return id;
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

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public Boolean getFavorite() {
        return favorite;
    }
}