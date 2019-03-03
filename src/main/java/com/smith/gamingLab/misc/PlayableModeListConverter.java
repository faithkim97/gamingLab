package com.smith.gamingLab.misc;

import com.smith.gamingLab.table.Genre;
import com.smith.gamingLab.table.PlayableMode;
import org.aspectj.apache.bcel.util.Play;
import org.springframework.lang.Nullable;

import javax.persistence.AttributeConverter;
import java.util.ArrayList;
import java.util.List;

public class PlayableModeListConverter implements AttributeConverter<List<PlayableMode>, String> {

    @Override
    public String convertToDatabaseColumn(List<PlayableMode> list) {
        List<String> modes = new ArrayList<>();
        list.forEach(m -> modes.add(m.getMode()));
        return String.join(",", modes);
    }

    @Override
    public List<PlayableMode> convertToEntityAttribute(@Nullable String joined) {
        List<PlayableMode> modes = new ArrayList<>();
        if (joined != null) {
            String[] joinedArr = joined.split(",");
            for (String mode : joinedArr) {
                modes.add(new PlayableMode(mode));
            }

        }
        return modes;
    }
}
