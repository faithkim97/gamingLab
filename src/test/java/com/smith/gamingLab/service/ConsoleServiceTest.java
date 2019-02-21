package com.smith.gamingLab.service;

import com.smith.gamingLab.repository.ConsoleRepository;
import com.smith.gamingLab.repository.GameConsoleMapRepository;
import com.smith.gamingLab.table.Console;
import com.smith.gamingLab.table.Game;
import com.smith.gamingLab.table.GameConsoleMap;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.Invocation;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class ConsoleServiceTest {
    @Mock
    private ConsoleRepository consoleRepository;

    @Mock
    private GameConsoleMapRepository mapRepository;

    @InjectMocks
    private ConsoleService consoleService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_getConsoleByType() {
        Console c = new Console();
        c.setConsole("ps4");
        when(consoleRepository.getConsoleByType(any(String.class))).thenReturn(c);
        assertEquals(c,consoleService.getConsoleByType("ps4"));
    }

    @Test
    public void test_getAllConsoles() {
        List<Console> consoles = Arrays.asList(new Console("ps4"), new Console("nintendo switch"), new Console("ps3"));
        when(consoleRepository.findAll()).thenReturn(consoles);
        assertEquals(consoles, consoleService.getAllConsoles());
    }

    //TODO is this the right way to do it?
    @Test
    public void test_saveConsole() {
        Console c = new Console("ps4");
        consoleService.saveConsole(c);
        verify(consoleRepository).save(c);
    }


    @Test
    public void test_deleteConsole() {
        int id = 1;
        consoleService.deleteConsole(id);
        verify(consoleRepository).deleteById(id);
    }

    @Test
    public void test_saveMapping() {
//        List<Console> consoles = Arrays.asList(new Console("ps4"), new Console("nintendo switch"), new Console("PC"));
        GameConsoleMap map = new GameConsoleMap( new Game("tomb raider"), new Console("ps4"));
        consoleService.saveGameConsoleMap(map);
        verify(mapRepository, times(1)).save(map);
//        consoleService.saveGameConsoleMap(new Game("tomb raider"), consoles);
    }

    @Test
    public void test_getAllMapping() {
        List<GameConsoleMap> map = Arrays.asList(new GameConsoleMap(new Game("tomb raider"), new Console("ps4")),
                                                    new GameConsoleMap(new Game("mario kart"), new Console("nintendo switch")));
        when(mapRepository.findAll()).thenReturn(map);
        assertEquals(map, consoleService.getAllGameConsoleMapping());
    }

    @Test
    public void test_deleteMapping() {
        int id = 1;
        consoleService.deleteMapping(id);
        verify(mapRepository).deleteById(id);
    }

    @Test
    public void test_deleteMappingByGameId() {
        //idk why but id needs to be 0 or else we get a arguments are different error
        int id = 0;
        List<GameConsoleMap> map = Arrays.asList(new GameConsoleMap(new Game(), new Console()),
                new GameConsoleMap(new Game("tomb raider"), new Console("ps4")));
        when(mapRepository.getMappingByGameId(any(Integer.class))).thenReturn(map);
        consoleService.deleteMappingByGameId(id);
        verify(mapRepository, times(map.size())).deleteById(id);
    }

    @Test
    public void test_deleteMappingByConsoleId() {
        int id = 0;
        List<GameConsoleMap> map = Arrays.asList(new GameConsoleMap(new Game(), new Console()),
                new GameConsoleMap(new Game("tomb raider"), new Console("ps4")));
        when(mapRepository.getMappingByConsoleId(any(Integer.class))).thenReturn(map);
        consoleService.deleteMappingByConsoleId(id);
        verify(mapRepository, times(map.size())).deleteById(id);
    }

    @Test
    public void test_getConsolesByGameId() {
        int id = 1;
        List<Console> consoles = Arrays.asList(new Console("ps4"), new Console("nintendo switch"), new Console("PC"));
        List<GameConsoleMap> map = new ArrayList<>();
        consoles.forEach(c -> map.add(new GameConsoleMap(new Game(), c)));
        when(mapRepository.getMappingByGameId(any(Integer.class))).thenReturn(map);
        assertEquals(consoles, consoleService.getConsolesByGameId(id));
        verify(mapRepository).getMappingByGameId(id);
    }

    @Test
    public void test_getGamesByConsoleId() {
        int id = 1;
        List<Game> games = Arrays.asList(new Game("tomb raider"), new Game("mario kart"), new Game("uncharted"));
        List<GameConsoleMap> map = new ArrayList<>();
        games.forEach(g -> map.add(new GameConsoleMap(g, new Console())));
        when(mapRepository.getMappingByConsoleId(any(Integer.class))).thenReturn(map);
        assertEquals(games, consoleService.getGamesByConsoleId(id));
        verify(mapRepository).getMappingByConsoleId(id);
    }

    @Test
    public void test_getMappingByGameId() {
        int id = 1;
        List<GameConsoleMap> map = Arrays.asList(new GameConsoleMap(new Game("tomb raider"), new Console("ps4")),
                new GameConsoleMap(new Game("tomb raider"), new Console("pc")), new GameConsoleMap(new Game("tomb raider"),
                        new Console("xbox")));
        when(mapRepository.getMappingByGameId(any(Integer.class))).thenReturn(map);
        assertEquals(map, consoleService.getMappingByGameId(id));
        verify(mapRepository).getMappingByGameId(id);
    }

    @Test
    public void test_getMappingByConsoleId() {
        int id = 1;
        List<GameConsoleMap> map = Arrays.asList(new GameConsoleMap(new Game("uncharted"), new Console("ps4")),
                new GameConsoleMap(new Game("uncharted"), new Console("ps4")), new GameConsoleMap(new Game("battlefield"),
                        new Console("ps4")));
        when(mapRepository.getMappingByConsoleId(any(Integer.class))).thenReturn(map);
        assertEquals(map, consoleService.getMappingByConsoleId(id));
        verify(mapRepository).getMappingByConsoleId(id);
    }












}//endclass
