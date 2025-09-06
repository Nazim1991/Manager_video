package ru.netology.project;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerTest {

    @Test
    public void shouldAddMovie() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Movie 1");

        String[] expected = {"Movie 1"};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    public void shouldAddMultipleMovies() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");
        manager.addMovie("Movie 3");

        String[] expected = {"Movie 1", "Movie 2", "Movie 3"};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    public void shouldFindAllMovies() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Film 1");
        manager.addMovie("Film 2");
        manager.addMovie("Film 3");

        String[] expected = {"Film 1", "Film 2", "Film 3"};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    public void shouldFindLastMoviesWithDefaultLimit() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");
        manager.addMovie("Movie 3");
        manager.addMovie("Movie 4");
        manager.addMovie("Movie 5");
        manager.addMovie("Movie 6");

        String[] expected = {"Movie 6", "Movie 5", "Movie 4", "Movie 3", "Movie 2"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void shouldFindLastMoviesWithCustomLimit() {
        MovieManager manager = new MovieManager(3);
        manager.addMovie("Film A");
        manager.addMovie("Film B");
        manager.addMovie("Film C");
        manager.addMovie("Film D");
        manager.addMovie("Film E");

        String[] expected = {"Film E", "Film D", "Film C"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void shouldFindLastMoviesWhenLessThanLimit() {
        MovieManager manager = new MovieManager(5);
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");
        manager.addMovie("Movie 3");

        String[] expected = {"Movie 3", "Movie 2", "Movie 1"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void shouldFindLastMoviesWhenExactlyLimit() {
        MovieManager manager = new MovieManager(4);
        manager.addMovie("Film 1");
        manager.addMovie("Film 2");
        manager.addMovie("Film 3");
        manager.addMovie("Film 4");

        String[] expected = {"Film 4", "Film 3", "Film 2", "Film 1"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void shouldReturnEmptyArrayWhenNoMovies() {
        MovieManager manager = new MovieManager();

        String[] expected = {};
        assertArrayEquals(expected, manager.findAll());
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void shouldHandleZeroLimit() {
        MovieManager manager = new MovieManager(0);
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");

        String[] expected = {};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void shouldHandleLargeLimit() {
        MovieManager manager = new MovieManager(10);
        manager.addMovie("Movie 1");
        manager.addMovie("Movie 2");
        manager.addMovie("Movie 3");

        String[] expected = {"Movie 3", "Movie 2", "Movie 1"};
        assertArrayEquals(expected, manager.findLast());
    }
}