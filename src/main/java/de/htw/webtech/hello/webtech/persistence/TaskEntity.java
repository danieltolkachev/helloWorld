package de.htw.webtech.hello.webtech.persistence;

import javax.persistence.*;

@Entity(name = "toDos")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "is_favorite")
    private Boolean favorite;

    public TaskEntity(String title, String description, Boolean favorite) {

        this.title = title;
        this.description = description;
        this.favorite = favorite;
    }

    protected TaskEntity() {    }

    public Long getId() {
        return id;
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

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public Boolean getFavorite() {
        return favorite;
    }
}