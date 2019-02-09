package com.smith.gamingLab.table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Genre {

    @GeneratedValue
    @Id
    private int id;
    private String genre;

    public Genre() {}

    public Genre(String genre) {
        this.genre = genre;
    }

    public int getId() { return id; }

    public String getGenre() { return genre; }

    public void setGenre(String genre) { this.genre = genre; }

}
