package com.smith.gamingLab.service;

import com.smith.gamingLab.repository.GameRepository;
import com.smith.gamingLab.table.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    public List<Game> getAllGames() {
        List<Game> games = new ArrayList<>();
        gameRepository.findAll().forEach(g -> games.add(g));
        return games;
    }

    public Game getGameById(int id) {
        return gameRepository.findById(id).get();
    }

    public void saveOrUpdate(Game game) {
        gameRepository.save(game);
    }

    public void delete(int id) {
        gameRepository.deleteById(id);
    }

//    public List<Game> getGameByGenre(String genre) {
//        return gameRepository.getGameByGenre(genre);
//    }

    public List<Game> getGameByFields(String title, String description) {
        return gameRepository.getGames(title, description);
    }

    public int getIdByGameTitle(String title) {
        return gameRepository.getGameIdByTitle(title);
    }

    public Game getGameByTitle(String title) {
        return gameRepository.getGameByTitle(title);
    }

    public List<Game> getGamesByTitle(String title) {
        return gameRepository.getGamesByTitle(title);
    }

    public List<Game> getGameByKey(String key) { return gameRepository.getGameByKeywords(key);}

    public List<Game> getGameByKey(String key, Boolean checkedOut) { return gameRepository.getGameByKeywords(key, checkedOut);}







}
