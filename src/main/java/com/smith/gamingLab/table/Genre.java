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

    public Genre() {
        super();
    }

    public Genre(String genre) {
        this.genre = genre;
    }

    public String getGenre() { return genre; }

    public int getId() { return id;}

    public void setId(int id) { this.id = id; }

    public void setGenre(String genre) { this.genre = genre; }
}
