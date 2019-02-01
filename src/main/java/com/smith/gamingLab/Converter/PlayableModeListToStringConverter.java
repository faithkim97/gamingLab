package com.smith.gamingLab.Converter;

import com.smith.gamingLab.constant_enum.PlayableMode;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.ArrayList;
import java.util.List;

@Converter
public class PlayableModeListToStringConverter implements AttributeConverter<List<PlayableMode>,String> {

    @Override
    public String convertToDatabaseColumn(List<PlayableMode> list) {
        String s = "";
        for (PlayableMode mode : list) {
            s += mode.getTypeText() +",";
        }
        return  s.substring(0, s.length() - 1);
    }

    @Override
    public List<PlayableMode> convertToEntityAttribute(String joined) {
        List<PlayableMode> modeList = new ArrayList<>();
        String[] strArr = joined.split(",");
        for (String s : strArr) {
            modeList.add(PlayableMode.getModeByText(s));
        }
        return modeList;
    }

}
