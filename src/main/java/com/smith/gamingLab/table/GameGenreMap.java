package com.smith.gamingLab.table;

import javax.persistence.*;

@Entity
public class GameGenreMap {
    @GeneratedValue
    @Id
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Game game;

    @ManyToOne(cascade = CascadeType.ALL)
    private Genre genre;

    public GameGenreMap() {
    }

    public GameGenreMap(Game game, Genre genre) {
        this.game = game;
        this.genre = genre;
    }

    public int getId() { return id; }

    public Game getGame() { return game; }

    public Genre getGenre() { return genre; }

    public void setGame(Game game) { this.game = game; }

    public void setGenre(Genre genre) { this.genre = genre;}

}
