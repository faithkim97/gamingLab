package com.smith.gamingLab.misc;

import com.smith.gamingLab.table.Console;
import com.smith.gamingLab.table.Game;
import com.smith.gamingLab.table.Genre;
import com.smith.gamingLab.table.PlayableMode;
import org.aspectj.apache.bcel.util.Play;

/** Fields used to make queries for the game*/
public class Query {
    private String keyword;

    private Game game;

    private Console console;

    private PlayableMode mode;

    private Genre genre;

    public Query() {}

    public Query(String key, Game game, Console console, PlayableMode mode, Genre genre) {
        this.keyword = key;
        this.game = game;
        this.console = console;
        this.mode = mode;
        this.genre = genre;
    }

    public static String nullIfEmpty(String input) {
        if (input == null) return null;
        if (input.trim().isEmpty()) {
            return null;
        }
        return input;
    }

    public String getKeyword() { return nullIfEmpty(keyword); }

    public Game getGame() { return game; }

    public Console getConsole() { return console; }

    public PlayableMode getMode() { return mode; }

    public Genre getGenre() { return genre; }


    public void setKeyword(String key) { this.keyword = key; }

    public void setGame(Game game) { this.game = game; }

    public void setConsole(Console console) { this.console = console; }

    public void setMode(PlayableMode mode) { this.mode = mode; }

    public void setGenre(Genre genre) { this.genre = genre; }


}
