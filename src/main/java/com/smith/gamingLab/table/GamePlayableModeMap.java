package com.smith.gamingLab.table;

import javax.persistence.*;

@Entity
@Table(name = "game_mode")
public class GamePlayableModeMap {

    @GeneratedValue
    @Id
    private int id;


    @ManyToOne(cascade = CascadeType.PERSIST)
    private Game game;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private PlayableMode mode;

    public GamePlayableModeMap() {}

    public GamePlayableModeMap(Game game, PlayableMode mode) {
        this.game = game;
        this.mode = mode;
    }

    public int getId() { return id; }

    public Game getGame() { return game; }

    public PlayableMode getPlayableMode() { return mode; }

    public void setGame(Game g) { game = g;}

    public void setPlayableMode(PlayableMode mode) { this.mode = mode; }

    public void setId(int id) {this.id = id;}
}
