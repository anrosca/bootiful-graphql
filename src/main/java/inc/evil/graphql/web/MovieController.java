package inc.evil.graphql.web;

import inc.evil.graphql.movies.domain.Movie;
import inc.evil.graphql.movies.domain.MovieInput;
import inc.evil.graphql.movies.service.MovieService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @QueryMapping(name = "movies")
    public List<Movie> getAllMovies() {
        return movieService.getAll();
    }

    @QueryMapping(name = "movieById")
    public Movie getMovieById(@Argument String id) {
        return movieService.getById(id);
    }

    @MutationMapping(name = "createMovie")
    public Movie createMovie(@Argument MovieInput movie) {
        return movieService.create(movie);
    }
}
