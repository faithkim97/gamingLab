package com.smith.gamingLab.service;

import com.smith.gamingLab.repository.GameRepository;
import com.smith.gamingLab.table.Game;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

public class GameServiceTest {

    @Mock
    GameRepository gameRepository;

    @InjectMocks
    GameService gameService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_getAllGames() {
        List<Game> games = Arrays.asList(new Game("tomb raider"), new Game("uncharted"), new Game("sims 4"));
        when(gameRepository.findAll()).thenReturn(games);
        assertEquals(games, gameService.getAllGames());
    }

//    @Test
//    public void test_getGameById() {
//        int id = 1;
//        Game g = new Game("tomb raider");
//        g.setId(1);
//        when(gameRepository.findById(anyInt()).get()).thenReturn(g);
//        assertEquals(g, gameService.getGameById(id));
//    }

    @Test
    public void test_saveGame() {
        Game g = new Game("tomb raider");
        gameService.saveOrUpdate(g);
        verify(gameRepository).save(g);
    }

    @Test
    public void test_deleteGame() {
        int id = 1;
        gameService.deleteGame(id);
        verify(gameRepository).deleteById(id);
    }

    @Test
    public void test_getGameByTitle() {
        List<Game> games = Arrays.asList(new Game("tomb raider"), new Game("tomb raider"), new Game("tomb raider"));
        //TODO get rid of any(String.class) since we'll always return a list of tomb raiders regardless of input?
        when(gameRepository.getGamesByExactTitle(any(String.class))).thenReturn(games);
        assertEquals(games, gameService.getGameByTitle("tomb raider"));
        verify(gameRepository).getGamesByExactTitle("tomb raider");
    }

    @Test
    public void test_getGamesByTitle() {
        List<Game> games = Arrays.asList(new Game("tomb raider shark"), new Game("hahatomb raider"), new Game("tomb raider right"));
        when(gameRepository.getGamesByTitle(any(String.class))).thenReturn(games);
        assertEquals(games, gameService.getGamesByTitle("tomb raider"));
        verify(gameRepository).getGamesByTitle("tomb raider");
    }

    //TODO write unit test for getGameByKeyword



}
