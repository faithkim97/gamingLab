package com.smith.gamingLab.Converter;

import com.smith.gamingLab.constant_enum.GenreType;
import com.smith.gamingLab.constant_enum.PlayableMode;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.ArrayList;
import java.util.List;

//TODO THIS IS REPETITIVE CODING HOW TO CONSOLIDATE??
@Converter
public class GenreTypeListToStringConverter implements AttributeConverter<List<GenreType>,String> {

    @Override
    public String convertToDatabaseColumn(List<GenreType> list) {
        String s = "";
        for (GenreType mode : list) {
            s += mode.getTypeText() +",";
        }
        return  s.substring(0, s.length() - 1);
    }

    @Override
    public List<GenreType> convertToEntityAttribute(String joined) {
        List<GenreType> modeList = new ArrayList<>();
        String[] strArr = joined.split(",");
        for (String s : strArr) {
            modeList.add(GenreType.getGenreByText(s));
        }
        return modeList;
    }

}
