    package de.htw.webtech.hello.webtech.web.api;

    import java.time.LocalDate;

    public class ToDo {

        private long id;
        private String title;
        private String description;
        private LocalDate date;
        private Boolean finished;
        private Boolean favorite;

        public ToDo(long id, String title, String description, LocalDate date, Boolean finished, Boolean favorite) {
            this.id = id;
            this.title = title;
            this.description = description;
            this.date = date;
            this.finished = finished;
            this.favorite = favorite;
        }

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        public Boolean isFinished() {
            return finished;
        }

        public void setFinished(Boolean finished) {
            this.finished = finished;
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