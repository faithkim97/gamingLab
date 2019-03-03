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
    private GameGenreMap genreMap;


    @ManyToOne(cascade = CascadeType.PERSIST)
    private GamePlayableModeMap modeMap;

    //TODO console

    public MasterGame() {}

    public MasterGame(Game g) { game = g;}

    public Game getGame() { return game; }

    public void setModeMap(GamePlayableModeMap modeMap) {
        this.modeMap = modeMap;
    }

    public void setGenreMap(GameGenreMap genreMap) {
        this.genreMap = genreMap;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GamePlayableModeMap getModeMap() {
        return modeMap;
    }

    public GameGenreMap getGenreMap() {
        return genreMap;
    }

    public int getId() {
        return id;
    }

    //    public Console getConsole() { return consoleMap.getConsole(); }
//
//    public List<Genre> getGenres() {
//        List<Genre> genres = new ArrayList<>();
//        if (genres.isEmpty()) {
//            genreMap.forEach(m -> genres.add(m.getGenre()));
//        }
//        return genres;
//    }
//
//    public List<PlayableMode> getModes() {
//        List<PlayableMode> modes = new ArrayList<>();
//        if (modes.isEmpty()) {
//            modeMap.forEach(m -> modes.add(m.getPlayableMode()));
//        }
//        return modes;
//    }
//
//    public void setGame(Game g) {
//        game = g;
//    }
//
//    public void setGenreMap(List<GameGenreMap> map) {
//        genreMap = map;
//    }
//
//    public void setPlayableModeMap(List<GamePlayableModeMap> map) {
//        modeMap = map;
//    }
//
//    public void setConsoleMap(GameConsoleMap map) {
//        consoleMap = map;
//    }







}
