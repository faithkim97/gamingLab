package com.smith.gamingLab.Converter;

import com.smith.gamingLab.constant_enum.GenreType;
import org.springframework.lang.Nullable;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TODO THIS IS REPETITIVE CODING HOW TO CONSOLIDATE??
@Converter
public class GenreTypeListToStringConverter implements AttributeConverter<List<GenreType>,String> {

    @Override
    public String convertToDatabaseColumn(List<GenreType> list) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i>0) {
                s.append(",");
            }
            GenreType mode = list.get(i);
            s.append(mode.getTypeText());
        }
        return  s.toString();
    }

    @Override
    public List<GenreType> convertToEntityAttribute(@Nullable String joined) {
        List<GenreType> genreList = new ArrayList<>();
        if (joined != null) {
            Arrays.asList(joined.split(",")).forEach(genre -> genreList.add(GenreType.getGenreByText(genre)));
        }
        return genreList;
    }

}
