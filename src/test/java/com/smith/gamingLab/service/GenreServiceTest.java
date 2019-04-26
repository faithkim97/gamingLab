package com.smith.gamingLab.service;

import com.smith.gamingLab.repository.GameGenreMapRepository;
import com.smith.gamingLab.repository.GenreRepository;
import com.smith.gamingLab.table.Game;
import com.smith.gamingLab.table.GameGenreMap;
import com.smith.gamingLab.table.Genre;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
    public void test_getGenreById() {
        Genre genre = new Genre("mock");
        when(genreRepository.findById(anyInt())).thenReturn(Optional.of(new Genre("mock")));
        assertEquals(genre.getGenre(), genreService.getGenreById(anyInt()).get().getGenre());
    }

    @Test
    public void test_getMappingById() {
        GameGenreMap map = new GameGenreMap();
        when(mapRepository.findById(anyInt())).thenReturn(Optional.of(map));
        assertEquals(map, genreService.getMappingById(anyInt()).get());
    }

//    @Test
//    public void test_getGenresByTitleToken() {
//        String genreTitles = "open world,casual,adventure";
//        String token = ",";
//        List<Genre> expected = Arrays.asList(new Genre("open world"), new Genre("casual"), new Genre("adventure"));
//        List<Genre> actual = genreService.getGenresByTitleToken(genreTitles, token);
//        assertEquals(expected.size(), actual.size());
//        for (int i = 0; i < expected.size(); i++) {
//            assertEquals(expected.get(i).getGenre(), actual.get(i).getGenre());
//        }
//       expected.forEach(g -> verify(genreRepository).getGenreByTitle(g.getGenre()));
//       actual.forEach(g -> verify(genreRepository).save(g));
//    }

    @Test
    public void test_getGenresByTitleToken_titleEmpty() {
        String genreTitle = "";
        String token = ",";
        List<Genre> expected = new ArrayList<>();
        List<Genre> actual = genreService.getGenresByTitleToken(genreTitle, token);
        assertEquals(expected.isEmpty(), actual.isEmpty());
        verify(genreRepository, never()).getGenreByTitle("");
        verify(genreRepository, never()).save(any(Genre.class));
    }

    @Test
    public void test_getAllGenres() {
        List<Genre> expected = Arrays.asList(new Genre("casual"), new Genre("indie"));
        when(genreRepository.findAll()).thenReturn(expected);
        List<Genre> actual = genreService.getAllGenres();
        assertEquals(expected.size(), actual.size());
        assertEquals(expected, actual);
    }

    @Test
    public void test_getGenres() {
        List<Genre> expected = Arrays.asList(new Genre("tomb raider"), new Genre("tomb"), new Genre("life tomb bomb"));
        when(genreRepository.getGenresByTitle(any(String.class))).thenReturn(expected);
        List<Genre> actual = genreService.getGenres("tomb");
        assertEquals(expected.size(), actual.size());
        assertEquals(expected, actual);
    }

    @Test
    public void test_getGenresByGameId() {
        int id = 0;
        Game g = new Game("tomb raider");
        List<GameGenreMap> map = Arrays.asList(new GameGenreMap(g, new Genre("casual")), new GameGenreMap(g, new Genre("adventure")));
        List<Genre> expected = Arrays.asList(new Genre("casual"), new Genre("adventure"));
        when(mapRepository.getMappingByGameId(anyInt())).thenReturn(map);
        List<Genre> actual = genreService.getGenresByGameId(id);
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i).getGenre(), actual.get(i).getGenre());
        }
    }

    @Test
    public void test_getGamesByGenreId() {
        int id = 1;
        Genre genre = new Genre("casual");
        List<GameGenreMap> map = Arrays.asList(new GameGenreMap(new Game("tomb raider"),genre),
                new GameGenreMap(new Game("uncharted"), genre));
        when(mapRepository.getMappingByGenreId(anyInt())).thenReturn(map);
        List<Game> expected = Arrays.asList(new Game("tomb raider"), new Game("uncharted"));
        List<Game> actual = genreService.getGamesByGenreId(id);
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i).getTitle(), actual.get(i).getTitle());
        }
    }

    @Test
    public void test_saveGenre() {
        Genre genre = new Genre("mock");
        genreService.saveGenre(genre);
        verify(genreRepository).save(genre);
    }

    @Test
    public void test_saveGameGenreMap() {
        GameGenreMap map = new GameGenreMap(new Game("mock game"), new Genre("mock genre"));
        genreService.saveGameGenreMap(map);
        verify(mapRepository).save(map);
    }

    @Test
    public void test_saveGameGenresMap_byGenres() {
        List<Genre> genres = Arrays.asList(new Genre("mock1"), new Genre("mock2"));
        Game game = new Game("mock");
        genreService.saveGameGenreMap(game, genres);
        verify(mapRepository, times(genres.size())).save(any(GameGenreMap.class));
    }

    @Test
    public void test_getAllGameGenreMap() {
        List<GameGenreMap> map = Arrays.asList(new GameGenreMap(new Game("mock game1"), new Genre("mock1")),
                new GameGenreMap(new Game("mock game 2"), new Genre("mock2")));
        when(mapRepository.findAll()).thenReturn(map);
        List<GameGenreMap> actual = genreService.getAllGameGenreMap();
        assertEquals(map.size(), actual.size());
        assertEquals(map, actual);
    }

    @Test
    public void test_deleteMappingByGameId() {
        List<GameGenreMap> map = Arrays.asList(new GameGenreMap(new Game("mock game1"), new Genre("mock1")),
                new GameGenreMap(new Game("mock game 2"), new Genre("mock2")));
        when(mapRepository.getMappingByGameId(anyInt())).thenReturn(map);
        genreService.deleteMappingByGameId(anyInt());
        verify(mapRepository, times(map.size())).deleteById(anyInt());
    }

    @Test
    public void test_deleteMappingByGenreId() {
        List<GameGenreMap> map = Arrays.asList(new GameGenreMap(new Game("mock game1"), new Genre("mock1")),
                new GameGenreMap(new Game("mock game 2"), new Genre("mock2")));
        when(mapRepository.getMappingByGenreId(anyInt())).thenReturn(map);
        genreService.deleteMappingByGenreId(anyInt());
        verify(mapRepository, times(map.size())).deleteById(anyInt());
    }

    @Test
    public void test_deleteGenre() {
        genreService.deleteGenre(anyInt());
        verify(genreRepository).deleteById(anyInt());
    }

    @Test
    public void test_deleteMapping() {
        genreService.deleteMapping(anyInt());
        verify(mapRepository).deleteById(anyInt());
    }


}//endclass
