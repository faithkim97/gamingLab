package com.smith.gamingLab.misc;

import com.smith.gamingLab.table.Console;
import com.smith.gamingLab.table.Game;
import com.smith.gamingLab.table.Genre;
import com.smith.gamingLab.table.PlayableMode;
import org.aspectj.apache.bcel.util.Play;

import java.util.List;

/** Fields used to make queries for the game*/
public class Query {
    private String keyword;

    private Game game;

    private Console console;

    private List<PlayableMode> modes;

    private List<Genre> genres;

    public Query() {}

    public Query(String key, Game game, Console console, List<PlayableMode> modes, List<Genre> genres) {
        this.keyword = key;
        this.game = game;
        this.console = console;
        this.modes = modes;
        this.genres = genres;
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

    public List<PlayableMode> getModes() { return modes; }

    public List<Genre> getGenres() { return genres; }


    public void setKeyword(String key) { this.keyword = key; }

    public void setGame(Game game) { this.game = game; }

    public void setConsole(Console console) { this.console = console; }

    public void setModes(List<PlayableMode> modes) { this.modes = modes; }

    public void setGenres(List<Genre> genres) { this.genres = genres; }


}
