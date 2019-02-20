package com.smith.gamingLab.service;

import com.smith.gamingLab.repository.ConsoleRepository;
import com.smith.gamingLab.repository.GameConsoleMapRepository;
import com.smith.gamingLab.table.Console;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

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



}//endclass
