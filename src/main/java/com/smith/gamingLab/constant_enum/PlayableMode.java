package com.smith.gamingLab.constant_enum;

import org.aspectj.apache.bcel.util.Play;

public enum PlayableMode {
    SINGLE_PLAYER("single player"),
    ONLINE_MULTIPLAYER("online multiplayer"),
    OFFLINE_MULTIPLAYER("offline multiplayer");

    private String modeText;

    PlayableMode(String modeText) {
        this.modeText = modeText;
    }

    public String getTypeText() {
        return modeText;
    }

    //TODO might not need this
    public static PlayableMode getModeByText(String text) {
        for (PlayableMode mode : PlayableMode.values()) {
            if (mode.modeText.equals(text)) {
                return mode;
            }
        }
        System.err.println("Could not find genre based on text " + text);
        return null;
    }

}
