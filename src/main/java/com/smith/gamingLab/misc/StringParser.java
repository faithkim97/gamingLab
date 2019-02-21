package com.smith.gamingLab.misc;

public class StringParser {

    public static String[] parseString(String title, String token) {
        String[] parsed = new String[0];
        if (title.isEmpty()) {
            return parsed;
        }
        parsed = title.split(token);
        return parsed;
    }
}
