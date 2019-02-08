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

    public Game getGameById(long id) {
        return gameRepository.findById(id).get();
    }

    public void saveOrUpdate(Game game) {
        gameRepository.save(game);
    }

    public void delete(long id) {
        gameRepository.deleteById(id);
    }

//    public List<Game> getGameByGenre(String genre) {
//        return gameRepository.getGameByGenre(genre);
//    }

    public List<Game> getGameByFields(String title, String description) {
        return gameRepository.getGames(title, description);
    }






}
