package com.smith.gamingLab.constant_enum;

public enum PlayableMode {
    SINGLE_PLAYER("single player"),
    ONLINE_MULTIPLAYER("online multiplayer"),
    OFFLINE_MULTIPLAYER("offline multiplayer");

    private String modeText;

    PlayableMode(String modeText) {
        this.modeText = modeText;
    }

}
