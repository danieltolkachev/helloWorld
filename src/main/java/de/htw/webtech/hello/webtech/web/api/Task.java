    package de.htw.webtech.hello.webtech.web.api;

    import java.time.LocalDate;

    public class Task {

        private long id;
        private String title;
        private String description;
        private Boolean favorite;

        public Task(long id, String title, String description, Boolean favorite) {
            this.id = id;
            this.title = title;
            this.description = description;
            this.favorite = favorite;
        }

        public long getId() {

            return id;
        }

        public void setId(long id) {

            this.id = id;
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

        public Boolean isFavorite() {
            return favorite;
        }

        public void setFavorite(Boolean favorite) {
            this.favorite = favorite;
        }
    }