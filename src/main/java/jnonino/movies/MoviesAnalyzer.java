package jnonino.movies;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Julian on 28/1/2017.
 */
public class MoviesAnalyzer {

    static Set<Movie> getBestRatedRelatedMovies(Movie movie, int amountMoviesToReturn) {
        SortedSet<Movie> result = new TreeSet<Movie>(Collections.reverseOrder(Comparator.comparing(Movie::getRating)));
        result.addAll(findMovies(result, movie));
        return result.stream().limit(amountMoviesToReturn).collect(Collectors.toSet());
    }

    private static Set<Movie> findMovies(Set<Movie> inputSet, Movie movie) {
        SortedSet<Movie> moviesToAnalyze = new TreeSet<Movie>(Collections.reverseOrder(Comparator.comparing(Movie::getRating)));
        if (!inputSet.contains(movie)) {
            moviesToAnalyze.add(movie);
        }
        if (!movie.getRelatedMovies().isEmpty()) {
            for (Movie m : movie.getRelatedMovies()) {
                moviesToAnalyze.addAll(findMovies(moviesToAnalyze, m));
            }
        }
        return moviesToAnalyze;
    }

    public static class Movie {

        private String title = "";
        private float rating = 0;
        private Set<Movie> relatedMovies = null;

        Movie(String title, float rating, Set<Movie> relatedMovies) {
            this.title = title;
            this.rating = rating;
            this.relatedMovies = relatedMovies;
        }

        public String getTitle() {
            return title;
        }

        float getRating() {
            return rating;
        }

        Set<Movie> getRelatedMovies() {
            return relatedMovies;
        }

        void setRelatedMovies(Set<Movie> relatedMovies) {
            this.relatedMovies = relatedMovies;
        }
    }
}
