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
    public void test_getAllMapping() {
        List<GameConsoleMap> map = Arrays.asList(new GameConsoleMap(new Game("tomb raider"), new Console("ps4")),
                                                    new GameConsoleMap(new Game("mario kart"), new Console("nintendo switch")));
        when(mapRepository.findAll()).thenReturn(map);
        assertEquals(map, consoleService.getAllGameConsoleMapping());
    }








}//endclass
