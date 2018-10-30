package jnonino.movies;

import jnonino.movies.MoviesAnalyzer.Movie;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Created by Julian on 28/1/2017.
 */
public class MoviesAnalyzerTest {

/**
* 									One (4.2)
* 				|-----------------------|-------------------|
* 			Two(5.0)				Three(1.6)			Four(2.9)
* 		|-----|--------|				|					|
* 		|	           |				|					|
*	Five(3.8)		Six(1.4)		Seven(0.3)			Eight(4.8)
* 		|
*	Nine(4.7)
*		|
*	Ten(4.9)
**/

    private Movie one = null;
    private Movie two = null;
    private Movie three = null;
    private Movie four = null;
    private Movie five = null;
    private Movie six = null;
    private Movie seven = null;
    private Movie eight = null;
    private Movie nine = null;
    private Movie ten = null;

    @Before
    public void setUp () {
        this.one = new Movie("One", 4.2f, Collections.<Movie>emptySet());
        this.two = new Movie("Two", 5.0f, Collections.<Movie>emptySet());
        this.three = new Movie("Three", 1.6f, Collections.<Movie>emptySet());
        this.four = new Movie("Four", 2.9f, Collections.<Movie>emptySet());
        this.five = new Movie("Five", 3.8f, Collections.<Movie>emptySet());
        this.six = new Movie("Six", 1.4f, Collections.<Movie>emptySet());
        this.seven = new Movie("Seven", 0.3f, Collections.<Movie>emptySet());
        this.eight = new Movie("Eight", 4.8f, Collections.<Movie>emptySet());
        this.nine = new Movie("Nine", 4.7f, Collections.<Movie>emptySet());
        this.ten = new Movie("Ten", 4.9f, Collections.<Movie>emptySet());

        Set<Movie> oneRelatedMovies = new HashSet<Movie>();
        oneRelatedMovies.add(this.two);
        oneRelatedMovies.add(this.three);
        oneRelatedMovies.add(this.four);
        this.one.setRelatedMovies(oneRelatedMovies);

        Set<Movie> twoRelatedMovies = new HashSet<Movie>();
        twoRelatedMovies.add(this.five);
        twoRelatedMovies.add(this.six);
        this.two.setRelatedMovies(twoRelatedMovies);

        Set<Movie> threeRelatedMovies = new HashSet<Movie>();
        threeRelatedMovies.add(this.seven);
        this.three.setRelatedMovies(threeRelatedMovies);

        Set<Movie> fourRelatedMovies = new HashSet<Movie>();
        fourRelatedMovies.add(this.eight);
        this.four.setRelatedMovies(fourRelatedMovies);

        Set<Movie> fiveRelatedMovies = new HashSet<Movie>();
        fiveRelatedMovies.add(this.nine);
        this.five.setRelatedMovies(fiveRelatedMovies);

        Set<Movie> nineRelatedMovies = new HashSet<Movie>();
        nineRelatedMovies.add(this.ten);
        this.nine.setRelatedMovies(nineRelatedMovies);
    }

    @Test
    public void fromOneGetThreeBestRatedRelatedMovies() {
        SortedSet<Movie> expected = new TreeSet<>(Collections.reverseOrder(Comparator.comparing(Movie::getRating)));
        expected.add(this.two);
        expected.add(this.ten);
        expected.add(this.eight);
        Set<Movie> actual = MoviesAnalyzer.getBestRatedRelatedMovies(this.one, 3);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void fromOneGetFiveBestRatedRelatedMovies() {
        SortedSet<Movie> expected = new TreeSet<>(Collections.reverseOrder(Comparator.comparing(Movie::getRating)));
        expected.add(this.two);
        expected.add(this.ten);
        expected.add(this.eight);
        expected.add(this.nine);
        expected.add(this.one);
        Set<Movie> actual = MoviesAnalyzer.getBestRatedRelatedMovies(this.one, 5);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void fromOneGetOneBestRatedRelatedMovies() {
        SortedSet<Movie> expected = new TreeSet<>(Collections.reverseOrder(Comparator.comparing(Movie::getRating)));
        expected.add(this.two);
        Set<Movie> actual = MoviesAnalyzer.getBestRatedRelatedMovies(this.one, 1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void fromFiveGetTwoBestRatedRelatedMovies() {
        SortedSet<Movie> expected = new TreeSet<>(Collections.reverseOrder(Comparator.comparing(Movie::getRating)));
        expected.add(this.ten);
        expected.add(this.nine);
        Set<Movie> actual = MoviesAnalyzer.getBestRatedRelatedMovies(this.five, 2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void fromFiveGetFourBestRatedRelatedMovies() {
        SortedSet<Movie> expected = new TreeSet<>(Collections.reverseOrder(Comparator.comparing(Movie::getRating)));
        expected.add(this.ten);
        expected.add(this.nine);
        expected.add(this.five);
        Set<Movie> actual = MoviesAnalyzer.getBestRatedRelatedMovies(this.five, 4);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void fromThreeGetFourBestRatedRelatedMovies() {
        SortedSet<Movie> expected = new TreeSet<>(Collections.reverseOrder(Comparator.comparing(Movie::getRating)));
        expected.add(this.three);
        expected.add(this.seven);
        Set<Movie> actual = MoviesAnalyzer.getBestRatedRelatedMovies(this.three, 4);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void fromThreeGetOneBestRatedRelatedMovies() {
        SortedSet<Movie> expected = new TreeSet<>(Collections.reverseOrder(Comparator.comparing(Movie::getRating)));
        expected.add(this.three);
        Set<Movie> actual = MoviesAnalyzer.getBestRatedRelatedMovies(this.three, 1);
        Assert.assertEquals(expected, actual);
    }

}
