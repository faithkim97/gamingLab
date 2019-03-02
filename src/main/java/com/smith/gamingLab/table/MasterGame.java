package com.smith.gamingLab.table;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "master_game")
public class MasterGame {

    @GeneratedValue
    @Id
    private int id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Game game;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private GameConsoleMap consoleMap;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private List<GameGenreMap> genreMap;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private List<GamePlayableModeMap> modeMap;


    public MasterGame() {}

    public Game getGame() { return game; }

    public Console getConsole() { return consoleMap.getConsole(); }

    public List<Genre> getGenres() {
        List<Genre> genres = new ArrayList<>();
        if (genres.isEmpty()) {
            genreMap.forEach(m -> genres.add(m.getGenre()));
        }
        return genres;
    }

    public List<PlayableMode> getModes() {
        List<PlayableMode> modes = new ArrayList<>();
        if (modes.isEmpty()) {
            modeMap.forEach(m -> modes.add(m.getPlayableMode()));
        }
        return modes;
    }

    public void setGame(Game g) {
        game = g;
    }

    public void setGenreMap(List<GameGenreMap> map) {
        genreMap = map;
    }

    public void setPlayableModeMap(List<GamePlayableModeMap> map) {
        modeMap = map;
    }

    public void setConsoleMap(GameConsoleMap map) {
        consoleMap = map;
    }







}
