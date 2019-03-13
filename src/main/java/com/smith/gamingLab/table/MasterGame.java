package com.smith.gamingLab.table;

import com.smith.gamingLab.misc.GameGenreMapListConverter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "master_game")
public class MasterGame {

    @GeneratedValue
    @Id
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Game game;

    @ManyToOne(cascade = CascadeType.ALL)
    private GameGenreMap genreMap;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private GamePlayableModeMap modeMap;

//    @Column
//    @Convert(converter = GenreListConverter.class)
//    private List<Genre> genres;
//
//    @Column
//    @Convert(converter = PlayableModeListConverter.class)
//    private List<PlayableMode> modes;

    @ManyToOne(cascade = CascadeType.ALL)
    private GameConsoleMap consoleMap;

    public MasterGame() {}

    public MasterGame(Game g) { game = g;}

    public GameConsoleMap getConsoleMap() { return consoleMap; }

    public Game getGame() { return game; }

//    public List<Genre> getGenres() { return genres;}

//    public List<PlayableMode> getModes() { return modes; }

//    public void setGenres(List<Genre> genres) { this.genres = genres;}

//    public void setModes(List<PlayableMode> modes) { this.modes = modes;}

    public void setConsole(Console c) { consoleMap.setConsole(c);}

    public void setConsoleMap(GameConsoleMap consoleMap) { this.consoleMap = consoleMap;}

    public void setGame(Game game) {
        this.game = game;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setGenreMap(GameGenreMap genreMap) { this.genreMap = genreMap;}

    public GameGenreMap getGenreMap() { return genreMap; }


    public void setModeMap(GamePlayableModeMap modeMap) { this.modeMap = modeMap; }
//
    public GamePlayableModeMap getModeMap() { return modeMap; }


}
