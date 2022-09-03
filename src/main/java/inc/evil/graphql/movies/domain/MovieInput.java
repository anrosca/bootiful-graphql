package inc.evil.graphql.movies.domain;

public record MovieInput(String name, int publishYear) {
    public Movie toMovie() {
        return Movie.builder()
                .name(name)
                .publishYear(publishYear)
                .build();
    }
}
