package com.smith.gamingLab.table;

import com.smith.gamingLab.Converter.ListToStringConverter;
import com.smith.gamingLab.constant_enum.ConsoleType;
import com.smith.gamingLab.constant_enum.GenreType;
import com.smith.gamingLab.constant_enum.PlayableMode;
import com.smith.gamingLab.constant_enum.Rating;

import javax.persistence.*;
import java.util.List;

@Entity
public class Game {
    @GeneratedValue
    @Id
    private int id;

    private String title;

    private ConsoleType consoleType;
    private Rating rating;
    private boolean isCheckedOut;
    private int quantity;
    private String description;
    private boolean isDigital;

    //TODO how to get

    /*TODO make genre a list of string, list of enum or just a string?
     *  Depends on query?
     * */
    @ManyToMany
    private List<GenreType> genres;

    //TODO make this into a HashSet instead?
    @Column
    @Convert(converter = ListToStringConverter.class)
    private List<PlayableMode> modes;

    public Game() {}

    public int getId() { return id; }

    public ConsoleType getConsoleType() { return consoleType; }

    public Rating getRating() { return rating; }

    public boolean getIsCheckedOut() { return isCheckedOut; }

    public int getQuantity() { return quantity; }

    public String getDescription() { return description; }

    public boolean getIsDigital() { return isDigital; }

//    public List<GenreType> getGenres() {return genres;}

//    public List<PlayableMode> getPlayableModes() { return modes; }

    //setters

    public void setConsoleType(ConsoleType consoleType) { this.consoleType = consoleType; }

    public void setRating(Rating rating) { this.rating = rating; }

    public void setIsCheckedOut(boolean isCheckedOut) { this.isCheckedOut = isCheckedOut; }

    public void setQuantity(int q) { quantity = q;}

    public void setDescription(String description) { this.description = description; }

    public void setIsDigital(boolean isDigital) { this.isDigital = isDigital; }

//    public void addGenre(GenreType genre) { genres.add(genre); }

//    //TODO unit test this
//    public void deleteGenre(GenreType genre) {
//        if (genres.contains(genre)) {
//            genres.remove(genre);
//        }
//    }

//    public void addPlayableMode(PlayableMode mode) { modes.add(mode);}
//
//    public void deletePlayableMode(PlayableMode mode) {
//        if (modes.contains(mode)) { modes.remove(mode); }
//    }










}
