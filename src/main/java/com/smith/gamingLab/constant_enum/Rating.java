package com.smith.gamingLab.constant_enum;
/** Using the ESRB Rating system*/
public enum Rating {
    E(0, "Suitable for everyone"),
    E_10(1, "Suitable for ages 10 and up"),
    T(2, "Suitable for teens"),
    M(3, "Suitable for ages 17 and up"),
    A(4, "Adults only, 18+");

    private int rank;
    private String desc;

    Rating(int rank, String desc) {
        this.rank = rank;
        this.desc = desc;
    }

    public int getRank() { return rank; }

    public String getDesc() {return desc;}
}
