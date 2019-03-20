package com.smith.gamingLab.constant_enum;
/** Using the ESRB Rating system*/
public enum Rating {
    E( "Suitable for everyone"),
    E_10( "Suitable for ages 10 and up"),
    T( "Suitable for teens"),
    M("Suitable for ages 17 and up"),
    A( "Adults only, 18+"),
    NONE("rating does not apply");

    private String description;

    Rating( String desc) {
        this.description = desc;
    }


    public String getDescription() {return description;}

}
