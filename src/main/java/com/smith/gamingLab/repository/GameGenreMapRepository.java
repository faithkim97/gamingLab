package com.smith.gamingLab.repository;

import com.smith.gamingLab.table.Game;
import com.smith.gamingLab.table.GameGenreMap;
import com.smith.gamingLab.table.Genre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//TODO move all genre/game queries to here
public interface GameGenreMapRepository extends CrudRepository<GameGenreMap, Integer> {

    @Query(value = "select genre from game_genre_map where game.id = ?1", nativeQuery = true)
    List<Genre> getGenresbyGameId(int id);

    @Query(value = "select game from game_genre_map where genre.id = ?1", nativeQuery = true)
    List<Game> getGamesByGenreId(int id);

    @Query (value = "select * from game_genre_map where game.id = ?1", nativeQuery = true)
    List<GameGenreMap> getMappingByGameId(int gameId);

    @Query(value = "select * from game_genre_map where genre.id = ?1", nativeQuery = true)
    List<GameGenreMap> getMappingByGenreId(int genreId);

}
