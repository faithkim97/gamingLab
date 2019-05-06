package com.smith.gamingLab.repository;

import com.smith.gamingLab.table.Game;
import com.smith.gamingLab.table.GameGenreMap;
import com.smith.gamingLab.table.Genre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//TODO move all genre/game queries to here
public interface GameGenreMapRepository extends CrudRepository<GameGenreMap, Integer> {

    @Query (value = "select * from game_genre where game_id = ?1", nativeQuery = true)
    List<GameGenreMap> getMappingByGameId(int gameId);

    @Query(value = "select * from game_genre where genre_id = ?1", nativeQuery = true)
    List<GameGenreMap> getMappingByGenreId(int genreId);

    @Query(value = "select * from game_genre where genre_id = ?1 and game_id = ?2", nativeQuery = true)
    List<GameGenreMap> getMappingByGameAndGenreIds(int genreId, int gameId);


}
