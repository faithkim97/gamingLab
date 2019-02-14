package com.smith.gamingLab.Misc;

public class StringParser {

    public static String[] parseString(String title, String token) {
        String[] parsed = new String[0];
        parsed = title.split(token);
        return parsed;
    }
}
