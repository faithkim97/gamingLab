package com.smith.gamingLab.constant_enum;

public enum GenreType {
    CASUAL("casual"),
    INDIE("indie"),
    FPS("first person shooter"),
    INTERACTIVE_DRAMA("interactive drama"),
    ADVENTURE("adventure"),
    SIMULATION("simulation"),
    RPG("role playing game"),
    RACING("racing"),
    OPEN_WORLD("open world"),
    ACTION_ADVENTURE("action adventure"),
    PUZZLE("puzzle"),
    EDUCATION("education"),
    DESIGN_ILLUSTRATOR("design illustrator"),
    MMORPG("online role-playing game"),
    HORROR("horror");

    private String genreText;

    GenreType(String genreText) {
        this.genreText = genreText;
    }


    public String getTypeText() { return genreText; }

    //TODO might not need this
    public static GenreType getGenreByText(String text) {
        for (GenreType g : GenreType.values()) {
            if (g.genreText.equals(text)) {
                return g;
            }
        }
        System.err.println("Could not find genre based on text " + text);
        return null;
    }

}
