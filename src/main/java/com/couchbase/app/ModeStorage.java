package com.couchbase.app;

import java.util.HashMap;

public class ModeStorage {
    static HashMap<String,Mode> modes = new HashMap<>();

    static {
        modes.put("il",new InitialMode());
        modes.put("ibr", new CDCMode());
    }

    public static HashMap<String, Mode> getModes() {
        return modes;
    }

    public static void setModes(HashMap<String, Mode> modes) {
        ModeStorage.modes = modes;
    }
}
