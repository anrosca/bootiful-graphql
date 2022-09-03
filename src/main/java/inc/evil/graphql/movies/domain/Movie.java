package inc.evil.graphql.movies.domain;

import inc.evil.graphql.common.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie extends AbstractEntity {
    private String name;
    private int publishYear;

    protected Movie() {
    }

    public Movie(MovieBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.publishYear = builder.publishYear;
    }

    public String getName() {
        return this.name;
    }

    public int getPublishYear() {
        return this.publishYear;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public static MovieBuilder builder() {
        return new MovieBuilder();
    }

    public String toString() {
        return "Movie(name=" + this.getName() + ", publishYear=" + this.getPublishYear() + ")";
    }

    public static class MovieBuilder {
        private String id;
        private String name;
        private int publishYear;

        public MovieBuilder id(String id) {
            this.id = id;
            return this;
        }

        public MovieBuilder name(String name) {
            this.name = name;
            return this;
        }

        public MovieBuilder publishYear(int publishYear) {
            this.publishYear = publishYear;
            return this;
        }

        public Movie build() {
            return new Movie(this);
        }
    }
}
