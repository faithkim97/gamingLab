package com.smith.gamingLab.constant_enum;

public enum ConsoleType {
    PS4_VR("PS4 VR"),
    PS4("PS4"),
    NINTENDO_SWITCH("Nintendo Switch"),
    PS3("PS3"),
    HTC_VIVE("HTC VIVE"),
    PC("PC"),
    XBOX_360("Xbox 360"),
    XBOX_1("Xbox 1"),
    OCCULUS("Occulus"),
    NES_CLASSIC("NES Classic");

    private String consoleText;

    ConsoleType(String consoleText) {
        this.consoleText = consoleText;
    }

    public String getConsoleText() { return consoleText; }

    public static ConsoleType getTypeByText(String text) {
        for (ConsoleType c : ConsoleType.values()) {
            if (c.consoleText.equals(text)) { return c;}
        }
        System.err.println("Unable to find console type with text " + text);
        return null;
    }









}
