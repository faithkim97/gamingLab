package com.smith.gamingLab.service;

import com.smith.gamingLab.constant_enum.Rating;
import com.smith.gamingLab.repository.GameRepository;
import com.smith.gamingLab.repository.MasterGameRepository;
import com.smith.gamingLab.table.Game;
import com.smith.gamingLab.table.MasterGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    MasterGameRepository masterGameRepository;

    public List<MasterGame> getAllMasterGames() {
        List<MasterGame> games = new ArrayList<>();
        masterGameRepository.findAll().forEach( g -> games.add(g));
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

    public void deleteGame(int id) {
        gameRepository.deleteById(id);
    }

    //TODO remove this??
    public int getIdByGameTitle(String title) {
        return gameRepository.getGameIdByTitle(title);
    }

    public List<Game> getGameByTitle(String title) {
        return gameRepository.getGamesByExactTitle(title);
    }

    public List<Game> getGamesByTitle(String title) {
        return gameRepository.getGamesByTitle(title);
    }

    public List<Game> getGameByKey(String key, Boolean checkedOut, Boolean isDigital, String console, String mode, String rating) {
        Rating rating_enum = rating != null ? Rating.valueOf(rating) : null;
        return gameRepository.getGameByKeywords(key, checkedOut, isDigital, console, mode, rating_enum != null ? rating_enum.ordinal() : null);
    }

    public List<MasterGame> getMasterGameByKey(String key, Boolean checkedOut, Boolean isDigital, Integer console, String mode, String rating) {
        Rating rating_enum = rating != null ? Rating.valueOf(rating) : null;
        return masterGameRepository.getGamesByKeyword(key, checkedOut, isDigital, console, mode, rating_enum != null ? rating_enum.ordinal() : null);
    }

}
