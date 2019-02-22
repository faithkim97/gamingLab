package com.smith.gamingLab.service;

import com.smith.gamingLab.repository.GamePlayableModeMapRepository;
import com.smith.gamingLab.repository.PlayableModeRepository;
import com.smith.gamingLab.table.Game;
import com.smith.gamingLab.table.GamePlayableModeMap;
import com.smith.gamingLab.table.PlayableMode;
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

public class PlayableModeTest {
    @Mock
    PlayableModeRepository modeRepository;

    @Mock
    GamePlayableModeMapRepository mapRepository;

    @InjectMocks
    PlayableModeService modeService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_getModeById() {
        PlayableMode p = new PlayableMode("mock");
        when(modeRepository.findById(anyInt())).thenReturn(Optional.of(p));
        assertEquals(p, modeService.getPlayableModeById(anyInt()).get());
    }

    @Test
    public void test_getMappingById() {
        GamePlayableModeMap map = new GamePlayableModeMap();
        when(mapRepository.findById(anyInt())).thenReturn(Optional.of(map));
        modeService.getMappingById(anyInt());
        assertEquals(map, modeService.getMappingById(anyInt()).get());
    }

    @Test
    public void test_getAllPlayableModes() {
        List<PlayableMode> modes = Arrays.asList(new PlayableMode("mock1"), new PlayableMode("mock2"));
        when(modeRepository.findAll()).thenReturn(modes);
        assertEquals(modes, modeService.getAllPlayableModes());
    }

    @Test
    public void test_getAllMapping() {
        List<GamePlayableModeMap> map = Arrays.asList(new GamePlayableModeMap(new Game("mock"), new PlayableMode("mock1")),
                new GamePlayableModeMap(new Game("mock2"), new PlayableMode("mock2")));
        when(mapRepository.findAll()).thenReturn(map);
        assertEquals(map, modeService.getAllMapping());
    }

    @Test
    public void test_savePlayableMode() {
        PlayableMode mode = new PlayableMode();
        modeService.savePlayableMode(mode);
        verify(modeRepository).save(mode);
    }

    @Test
    public void test_saveMapping() {
        GamePlayableModeMap map = new GamePlayableModeMap();
        modeService.saveMapping(map);
        verify(mapRepository).save(map);
    }

    @Test
    public void test_getPlayableModeByTitle() {
        PlayableMode expected = new PlayableMode("mock");
        when(modeRepository.getMode(anyString())).thenReturn(new PlayableMode("mock"));
        assertEquals(expected.getMode(), modeService.getPlayableModeByTitle(anyString()).getMode());
    }

    @Test
    public void test_getPlayableModes() {
        String modeTitle = "single player,multiplayer";
        String token = ",";
        List<PlayableMode> expected = Arrays.asList(new PlayableMode("single player"), new PlayableMode("multiplayer"));
        List<PlayableMode> actual = modeService.getPlayableModes(modeTitle, token);
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i).getMode(), actual.get(i).getMode());
        }
        expected.forEach(p -> verify(modeRepository).getMode(p.getMode()));
        actual.forEach(p -> verify(modeRepository).save(p));
    }

    @Test
    public void test_getPlayableModes_titleEmpty() {
        String title = "";
        String token = ",";
        List<PlayableMode> expected = new ArrayList<>();
        List<PlayableMode> actual = modeService.getPlayableModes(title, token);
        assertEquals(expected.size(), actual.size());
        verify(modeRepository, never()).getMode(anyString());
        verify(modeRepository, never()).save(any(PlayableMode.class));
    }

    @Test
    public void test_saveMappings() {
        List<PlayableMode> modes = Arrays.asList(new PlayableMode("mock1"), new PlayableMode("mock2"), new PlayableMode("mock3"));
        Game game = new Game("mock game");
        modeService.saveMapping(game, modes);
        verify(mapRepository, times(modes.size())).save(any(GamePlayableModeMap.class));
    }

    @Test
    public void test_getModesByGameId() {
        List<PlayableMode> expected = Arrays.asList(new PlayableMode("mock1"), new PlayableMode("mock2"), new PlayableMode("mock3"));
        List<GamePlayableModeMap> map = new ArrayList<>();
        expected.forEach(m -> map.add(new GamePlayableModeMap(new Game("mock"), m)));
        when(mapRepository.getMappingByGameId(anyInt())).thenReturn(map);
        List<PlayableMode> actual = modeService.getModesByGameId(anyInt());
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i).getMode(), actual.get(i).getMode());
        }
    }

    @Test
    public void test_getGamesByPlayableModeId() {
        List<Game> expected = Arrays.asList(new Game("mock1"), new Game("mock2"), new Game("mock3"));
        List<GamePlayableModeMap> map = new ArrayList<>();
        expected.forEach(g -> map.add(new GamePlayableModeMap(g, new PlayableMode("mock"))));
        when(mapRepository.getMappingByPlayableId(anyInt())).thenReturn(map);
        List<Game> actual = modeService.getGamesByPlayableModeId(anyInt());
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i).getTitle(), actual.get(i).getTitle());
        }
    }

    @Test
    public void test_getMappingByGameId() {
        List<GamePlayableModeMap> expected = Arrays.asList(new GamePlayableModeMap(new Game("mock"), new PlayableMode("single player")));
        when(mapRepository.getMappingByGameId(anyInt())).thenReturn(expected);
        List<GamePlayableModeMap> actual = modeService.getMappingByGameId(anyInt());
        assertEquals(expected.size(), actual.size());
        assertEquals(expected, actual);
    }

    @Test
    public void test_getMappingByModeId() {
        List<GamePlayableModeMap> expected = Arrays.asList(new GamePlayableModeMap(new Game("mock"), new PlayableMode("single player")));
        when(mapRepository.getMappingByPlayableId(anyInt())).thenReturn(expected);
        List<GamePlayableModeMap> actual = modeService.getMappingByModeId(anyInt());
        assertEquals(expected.size(), actual.size());
        assertEquals(expected, actual);
    }

    @Test
    public void test_deletePlayableMode() {
        when(modeRepository.findById(anyInt())).thenReturn(Optional.of(new PlayableMode()));
        modeService.deletePlayableMode(anyInt());
        verify(modeRepository).deleteById(anyInt());
    }

    @Test
    public void test_deletePlayableMode_invalidId() {
        when(modeRepository.findById(-1)).thenReturn(Optional.empty());
        modeService.deletePlayableMode(-1);
        verify(modeRepository, never()).deleteById(-1);
    }

    @Test
    public void test_deleteMappingByGameId() {
        List<GamePlayableModeMap> map = Arrays.asList(new GamePlayableModeMap(new Game("mock1"), new PlayableMode("Mock1")));
        when(mapRepository.getMappingByGameId(anyInt())).thenReturn(map);
        modeService.deleteMappingByGameId(anyInt());
        verify(mapRepository, times(map.size())).deleteById(anyInt());
    }

    @Test
    public void test_deleteMappingByModeId() {
        List<GamePlayableModeMap> map = Arrays.asList(new GamePlayableModeMap(new Game("mock1"), new PlayableMode("Mock1")));
        when(mapRepository.getMappingByPlayableId(anyInt())).thenReturn(map);
        modeService.deleteMappingByModeId(anyInt());
        verify(mapRepository, times(map.size())).deleteById(anyInt());
    }

    @Test
    public void test_deleteMappingByModeId_emptyMap() {
        List<GamePlayableModeMap> emptyMap = new ArrayList<>();
        when(mapRepository.getMappingByPlayableId(-1)).thenReturn(emptyMap);
        modeService.deleteMappingByModeId(-1);
        verify(mapRepository, never()).deleteById(anyInt());
    }

    @Test
    public void test_deleteMappingByGameId_emptyMap() {
        List<GamePlayableModeMap> emptyMap = new ArrayList<>();
        when(mapRepository.getMappingByGameId(-1)).thenReturn(emptyMap);
        modeService.deleteMappingByGameId(-1);
        verify(mapRepository, never()).deleteById(anyInt());
    }

    @Test
    public void test_deleteMappingById() {
        when(mapRepository.findById(anyInt())).thenReturn(Optional.of(new GamePlayableModeMap()));
        modeService.deleteMappingById(anyInt());
        verify(mapRepository).deleteById(anyInt());
    }


}
