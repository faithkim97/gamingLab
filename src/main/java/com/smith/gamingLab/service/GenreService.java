package com.smith.gamingLab.service;

import com.smith.gamingLab.repository.GameGenreMapRepository;
import com.smith.gamingLab.repository.GenreRepository;
import com.smith.gamingLab.table.Game;
import com.smith.gamingLab.table.GameConsoleMap;
import com.smith.gamingLab.table.GameGenreMap;
import com.smith.gamingLab.table.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenreService {

    @Autowired
    GenreRepository genreRepository;

    @Autowired
    GameGenreMapRepository gameGenreMapRepository;

    public Genre getGenreByTitle(String title) {
        return genreRepository.getGenreByTitle(title);
    }

    public List<Genre> getAllGenres() {
        List<Genre> genres = new ArrayList<>();
        genreRepository.findAll().forEach(g -> genres.add(g));
        return genres;
    }


    public List<Genre> getGenresByTitle(String title) {
        return genreRepository.getGenresByTitle(title);
    }

    public List<Genre> getGenresByGame(Game game) {
        return gameGenreMapRepository.getGenresbyGameId(game.getId());
    }

    public List<Game> getGamesByGenre(Genre genre) {
        return gameGenreMapRepository.getGamesByGenreId(genre.getId());
    }

    public void saveGenre(Genre genre) {
        genreRepository.save(genre);
    }

    public void saveGameGenreMap(GameGenreMap gameGenreMap) {
        gameGenreMapRepository.save(gameGenreMap);
    }

    public List<GameGenreMap> getAllGameGenreMap() {
        List<GameGenreMap> map = new ArrayList<>();
        gameGenreMapRepository.findAll().forEach(g -> map.add(g));
        return map;
    }


}
