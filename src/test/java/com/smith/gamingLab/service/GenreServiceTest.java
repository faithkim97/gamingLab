package com.smith.gamingLab.service;

import com.smith.gamingLab.repository.GameGenreMapRepository;
import com.smith.gamingLab.repository.GenreRepository;
import com.smith.gamingLab.table.Genre;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

public class GenreServiceTest {
    @Mock
    GenreRepository genreRepository;

    @Mock
    GameGenreMapRepository mapRepository;

    @InjectMocks
    GenreService genreService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_getGenresByTitleToken() {
        String genreTitles = "open world,casual,adventure";
        String token = ",";
        List<Genre> expected = Arrays.asList(new Genre("open world"), new Genre("casual"), new Genre("adventure"));
        List<Genre> actual = genreService.getGenresByTitleToken(genreTitles, token);
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i).getGenre(), actual.get(i).getGenre());
        }

       verify(genreRepository).getGenreByTitle("open world");
       verify(genreRepository).getGenreByTitle("casual");
       verify(genreRepository).getGenreByTitle("adventure");

    }
}
