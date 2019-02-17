package com.smith.gamingLab.service;

import com.smith.gamingLab.Misc.StringParser;
import com.smith.gamingLab.repository.GameGenreMapRepository;
import com.smith.gamingLab.repository.GenreRepository;
import com.smith.gamingLab.table.Game;
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

    //TODO lowercase everything for genre
    public List<Genre> getGenresByTitleToken(String title, String token) {
        List<Genre> genres = new ArrayList<>();
        String[] parsed = StringParser.parseString(title, token);
        if (parsed.length > 0) {
            Genre genre;
            for (String g : parsed) {
                genre = genreRepository.getGenreByTitle(g);
                if (genre == null) {
                    genre = new Genre(g);
                }//endif
                saveGenre(genre);
                genres.add(genre);
            }
        }
        return genres;
    }



    public List<Genre> getAllGenres() {
        List<Genre> genres = new ArrayList<>();
        genreRepository.findAll().forEach(g -> genres.add(g));
        return genres;
    }


    public List<Genre> getGenres(String title) {
        return genreRepository.getGenresByTitle(title);
    }

    public List<Genre> getGenresByGameId(int gameId) {
        List<Genre> genres = new ArrayList<>();
        List<GameGenreMap> map = gameGenreMapRepository.getMappingByGameId(gameId);
        map.forEach(m -> genres.add(m.getGenre()));
        return genres;
    }

    public List<Game> getGamesByGenreId(int genreId) {
        List<Game> games = new ArrayList<>();
        List<GameGenreMap> map = gameGenreMapRepository.getMappingByGenreId(genreId);
        map.forEach(m -> games.add(m.getGame()));
        return games;
    }

    public void saveGenre(Genre genre) {
        genreRepository.save(genre);
    }

    public void saveGameGenreMap(GameGenreMap gameGenreMap) {
        gameGenreMapRepository.save(gameGenreMap);
    }

    @Deprecated
    public void saveGameGenreMap(Game game, String genreStr) {
        List<Genre> genres = getGenresByTitleToken(genreStr, ",");
        genres.forEach(g -> saveGameGenreMap(new GameGenreMap(game, g)));
    }

    public void saveGameGenreMap(Game game, List<Genre> genres) {
        genres.forEach(g -> saveGameGenreMap(new GameGenreMap(game, g)));
    }
    public List<GameGenreMap> getAllGameGenreMap() {
        List<GameGenreMap> map = new ArrayList<>();
        gameGenreMapRepository.findAll().forEach(g -> map.add(g));
        return map;
    }


    public void deleteMappingByGameId(int gameId) {
        List<GameGenreMap> map = gameGenreMapRepository.getMappingByGameId(gameId);
        map.forEach(m -> deleteMapping(m.getId()));
    }

    /**Should only be used when deleting genre from genre table*/
    //TODO unit test this
    public void deleteMappingByGenreId(int genreId) {
        List<GameGenreMap> map = gameGenreMapRepository.getMappingByGenreId(genreId);
        map.forEach(m-> deleteMapping(m.getId()));
    }

    public void deleteGenre(int genreId) {
        deleteMappingByGenreId(genreId);
        genreRepository.deleteById(genreId);
    }

    public void deleteMapping(int id) {
        gameGenreMapRepository.deleteById(id);
    }

}
