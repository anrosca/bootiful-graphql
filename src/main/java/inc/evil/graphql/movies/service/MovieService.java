package inc.evil.graphql.movies.service;

import inc.evil.graphql.movies.domain.Movie;
import inc.evil.graphql.movies.domain.MovieInput;
import inc.evil.graphql.movies.repository.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Transactional(readOnly = true)
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Movie getById(String id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException("No movie with id: '" + id + "' was found."));
    }

    @Transactional
    public Movie create(MovieInput movieInput) {
        return movieRepository.save(movieInput.toMovie());
    }
}
