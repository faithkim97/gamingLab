package com.smith.gamingLab.service;

import com.smith.gamingLab.Misc.StringParser;
import com.smith.gamingLab.repository.GamePlayableModeMapRepository;
import com.smith.gamingLab.repository.PlayableModeRepository;
import com.smith.gamingLab.table.Game;
import com.smith.gamingLab.table.GamePlayableModeMap;
import com.smith.gamingLab.table.PlayableMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayableModeService {

    @Autowired
    private PlayableModeRepository playableModeRepository;

    @Autowired
    private GamePlayableModeMapRepository mapRepository;

    public List<PlayableMode> getAllPlayableModes() {
        List<PlayableMode> modes = new ArrayList<>();
        playableModeRepository.findAll().forEach(m -> modes.add(m));
        return modes;
    }

    public List<GamePlayableModeMap> getAllMapping() {
        List<GamePlayableModeMap> map = new ArrayList<>();
        mapRepository.findAll().forEach(m -> map.add(m));
        return map;
    }

    public void savePlayableMode(PlayableMode pm) {
        playableModeRepository.save(pm);
    }

    public void saveMapping(GamePlayableModeMap map) {
        mapRepository.save(map);
    }

    public PlayableMode getPlayableModeByTitle(String title) {
        return playableModeRepository.getMode(title);
    }


    public List<PlayableMode> getPlayableModes(String modeName, String token) {
        List<PlayableMode> modes = new ArrayList<>();
        String[] parsed = StringParser.parseString(modeName, token);
        if (parsed.length > 0) {
            PlayableMode pm;
            for (String p : parsed) {
                pm = playableModeRepository.getMode(p);
                if (pm == null) {
                    pm = new PlayableMode(modeName);
                }

                savePlayableMode(pm);
                modes.add(pm);
            }
        }

        return modes;
    }

    public void saveMapping(Game g, List<PlayableMode> modes) {
        modes.forEach(m -> saveMapping(new GamePlayableModeMap(g, m)));
    }


    public List<PlayableMode> getModesByGameId(int gameId) {
        List<PlayableMode> modes = new ArrayList<>();
        List<GamePlayableModeMap> map =  mapRepository.getMappingByGameId(gameId);
        map.forEach(m -> modes.add(m.getPlayableMode()));
        return modes;
    }

    public List<Game> getGamesByPlayableModeId(int modeId) {
        List<Game> games = new ArrayList<>();
        List<GamePlayableModeMap> map = mapRepository.getMappingByPlayableId(modeId);
        map.forEach(m -> games.add(m.getGame()));
        return games;
    }

    public List<GamePlayableModeMap> getMappingByGameId(int id) {
        return mapRepository.getMappingByGameId(id);
    }

    public List<GamePlayableModeMap> getMappingByModeId(int id) {
        return mapRepository.getMappingByPlayableId(id);
    }

    public void deletePlayableMode(int modeId) {
        deleteMappingByModeId(modeId);
        playableModeRepository.deleteById(modeId);
    }

    public void deleteMappingByGameId(int gameId) {
        List<GamePlayableModeMap> map = getMappingByGameId(gameId);
        map.forEach(m -> deleteMappingById(m.getId()));
    }

    public void deleteMappingByModeId(int modeId) {
        List<GamePlayableModeMap> map = getMappingByModeId(modeId);
        map.forEach(m->deleteMappingById(m.getId()));
    }

    private void deleteMappingById(int id) {
        mapRepository.deleteById(id);
    }


}
