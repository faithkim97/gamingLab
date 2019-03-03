package com.smith.gamingLab.misc;

import com.smith.gamingLab.table.GameGenreMap;
import com.smith.gamingLab.table.Genre;
import org.springframework.lang.Nullable;

import javax.persistence.AttributeConverter;
import java.util.ArrayList;
import java.util.List;

public class GenreListConverter implements AttributeConverter<List<Genre>, String> {

    @Override
    public String convertToDatabaseColumn(List<Genre> list) {
        List<String> genres = new ArrayList<>();
        list.forEach(g -> genres.add(g.getGenre()));
        return String.join(",", genres);
    }

    @Override
    public List<Genre> convertToEntityAttribute(@Nullable String joined) {
        List<Genre> genres = new ArrayList<>();
        if (joined != null) {
            String[] joinedArr = joined.split(",");
            for (String g : joinedArr) {
                genres.add(new Genre(g));
            }

        }
        return genres;
    }
}
