package com.smith.gamingLab.service;

import com.smith.gamingLab.constant_enum.Rating;
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

    public void deleteGame(int id) {
        gameRepository.deleteById(id);
    }

//    public List<Game> getGameByGenre(String genre) {
//        return gameRepository.getGameByGenre(genre);
//    }

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


    //TODO fix query
    public List<Game> getGameByKey(String key, Boolean checkedOut, Boolean isDigital, String console, int rating, String mode)
    { return gameRepository.getGameByKeywords(key, checkedOut, isDigital, console, rating, mode);}

}
