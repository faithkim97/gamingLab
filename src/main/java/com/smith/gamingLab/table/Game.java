package com.smith.gamingLab.table;
//@Lob
import com.smith.gamingLab.constant_enum.Rating;

import javax.persistence.*;

@Entity
public class Game {
    @GeneratedValue
    @Id
    private int id;

    private String title;
    private Rating rating;
    private Boolean isCheckedOut;
    private int quantity = 1;

    @Column
    @Lob
    private String description;
    private Boolean isDigital;

    public Game() {}
    public Game(String title) { this.title = title;}

    public int getId() { return id; }

    public String getTitle() { return title; }

    public Rating getRating() { return rating; }

    public Boolean getIsCheckedOut() { return isCheckedOut; }

    public int getQuantity() { return quantity; }

    public String getDescription() { return description; }

    public Boolean getIsDigital() { return isDigital; }

    public void setRating(Rating rating) { this.rating = rating; }

    public void setRating(String r) {
        Rating rate = Rating.valueOf(r);
        if (rate != null) {
            rating = rate;
        }
    }

    public void setTitle(String title) { this.title = title; }

    public void setIsCheckedOut(Boolean isCheckedOut) { this.isCheckedOut = isCheckedOut; }

    public void setQuantity(int q) { quantity = q;}

    public void setDescription(String description) { this.description = description; }

    public void setIsDigital(Boolean isDigital) { this.isDigital = isDigital; }

    public void setId(int id) {this.id = id;}



}
