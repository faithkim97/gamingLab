package com.smith.gamingLab.repository;

import com.smith.gamingLab.table.Game;
import com.smith.gamingLab.table.GameGenreMap;
import com.smith.gamingLab.table.Genre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GameGenreMapRepository extends CrudRepository<GameGenreMap, Integer> {

    @Query(value = "select genre from genre where game.id = ?1", nativeQuery = true)
    List<Genre> getGenresbyGameId(int id);

    @Query(value = "select game from genre where genre.id = ?1", nativeQuery = true)
    List<Game> getGamesByGenreId(int id);
}
