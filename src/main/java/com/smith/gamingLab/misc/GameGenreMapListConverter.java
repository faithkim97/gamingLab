package com.smith.gamingLab.misc;

import com.smith.gamingLab.table.GameGenreMap;
import com.smith.gamingLab.table.Genre;
import org.springframework.lang.Nullable;

import javax.persistence.AttributeConverter;
import java.util.ArrayList;
import java.util.List;

public class GameGenreMapListConverter implements AttributeConverter<List<GameGenreMap>, String> {

    @Override
    public String convertToDatabaseColumn(List<GameGenreMap> list) {
        List<String> genres = new ArrayList<>();
        list.forEach(g -> genres.add(g.getGenre().getGenre()));
        return String.join(",", genres);
    }

    @Override
    public List<GameGenreMap> convertToEntityAttribute(@Nullable String joined) {
        List<GameGenreMap> genres = new ArrayList<>();
        if (joined != null) {
            String[] joinedArr = joined.split(",");
            for (String g : joinedArr) {
                genres.add(new GameGenreMap(new Genre(g)));
            }

        }
        return genres;
    }
}
