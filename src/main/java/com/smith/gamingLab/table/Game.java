package com.smith.gamingLab.table;

import com.smith.gamingLab.constant_enum.Rating;

import javax.persistence.*;

@Entity
public class Game {
    @GeneratedValue
    @Id
    private int id;

    private String title;
    private Rating rating;
    private boolean isCheckedOut;
    private int quantity;
    private String description;
    private boolean isDigital;

    public Game() {}

    public int getId() { return id; }

    public String getTitle() { return title; }

    public Rating getRating() { return rating; }

    public boolean getIsCheckedOut() { return isCheckedOut; }

    public int getQuantity() { return quantity; }

    public String getDescription() { return description; }

    public boolean getIsDigital() { return isDigital; }

    public void setRating(Rating rating) { this.rating = rating; }

    public void setRating(String r) {
        Rating rate = Rating.valueOf(r);
        if (rate != null) {
            rating = rate;
        }
    }

    public void setTitle(String title) { this.title = title; }

    public void setIsCheckedOut(boolean isCheckedOut) { this.isCheckedOut = isCheckedOut; }

    public void setQuantity(int q) { quantity = q;}

    public void setDescription(String description) { this.description = description; }

    public void setIsDigital(boolean isDigital) { this.isDigital = isDigital; }



}
