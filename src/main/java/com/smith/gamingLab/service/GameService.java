package com.smith.gamingLab.service;

import com.smith.gamingLab.constant_enum.Rating;
import com.smith.gamingLab.repository.GameRepository;
import com.smith.gamingLab.repository.MasterGameRepository;
import com.smith.gamingLab.table.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    MasterGameRepository masterGameRepository;

    public List<MasterGame> getAllMasterGames() {
        List<MasterGame> games = new ArrayList<>();
        masterGameRepository.findAll().forEach( g -> games.add(g));
        Comparator<MasterGame> comparator = (MasterGame g1, MasterGame g2)->Integer.compare(g1.getGame().getId(), g2.getGame().getId());
        Collections.sort(games, comparator);
        return games;
    }

    public List<Game> getAllGames() {
        List<Game> games = new ArrayList<>();
        gameRepository.findAll().forEach(g -> games.add(g));
        return games;
    }

    public Optional<Game> getGameById(int id) {
        return gameRepository.findById(id);
    }

    public void saveOrUpdate(Game game) {
        gameRepository.save(game);
    }

    public void saveMasterGame(MasterGame game) {
        masterGameRepository.save(game);
    }

    public void deleteMasterGame(int id) {masterGameRepository.deleteById(id);}

    public List<Integer> getMasterGameIdsByGameId(int gameId) { return masterGameRepository.getMasterGameByGameId(gameId);}

    public void deleteGame(int id) {
        gameRepository.deleteById(id);
    }

    public void deleteMasterGamesByGameId(int gameId) {
        List<Integer> masterGameIds = getMasterGameIdsByGameId(gameId);
        if (masterGameIds != null || !masterGameIds.isEmpty()) {
            for (int id : masterGameIds) {
                deleteMasterGame(id);
            }
        }
    }

    //todo SHOULD BE A LIST
    public List<MasterGame> getMasterGamesByConsoleMap(int mapId) {
        return masterGameRepository.getMasterGamesByConsoleMap(mapId);
    }

    public List<MasterGame> getMasterGamesByGenreMap(int genreMapId) {
        return masterGameRepository.getMasterGamesByGenreMap(genreMapId);
    }

    public List<MasterGame> getMasterGamesByModeMap(int modeMapId) {
        return masterGameRepository.getMasterGamesByModeMap(modeMapId);
    }
//    public void deleteConsoleMap(List<GameConsoleMap> consoleMap) {
//        List<MasterGame> games = new ArrayList<>();
//        consoleMap.forEach( c -> games.add(getMasterGamesByConsoleMap(c.getId())));
//        games.forEach(g -> g.setConsoleMap(null));
//    }

    public List<MasterGame> getMasterGamesByGenre(Genre genre) {
        return masterGameRepository.getMasterGamesByGenre(genre.getGenre());
    }

    public List<Game> getGameByTitle(String title) {
        return gameRepository.getGamesByExactTitle(title);
    }

    public List<Game> getGamesByTitle(String title) {
        return gameRepository.getGamesByTitle(title);
    }

    public List<MasterGame> getMasterGameByKey(String key, Boolean checkedOut, Boolean isDigital, Integer console, Integer modeId, String rating) {
        Rating rating_enum = rating != null ? Rating.valueOf(rating) : null;
        return masterGameRepository.getGamesByKeyword(key, checkedOut, isDigital, console, modeId, rating_enum != null ? rating_enum.ordinal() : null);
    }


    public List<MasterGame> getMasterGamesByMode(PlayableMode mode) {
        return masterGameRepository.getMasterGamesByMode(mode.getMode());
    }

}
