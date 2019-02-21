package com.smith.gamingLab.repository;

import com.smith.gamingLab.table.Genre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GenreRepository extends CrudRepository<Genre, Integer> {

    @Query(value = "select * from genre where genre=?1", nativeQuery = true)
    Genre getGenreByTitle(String genre);

    @Query(value = "select * from genre where genre like %?1%", nativeQuery = true)
    List<Genre> getGenresByTitle(String genre);


}
