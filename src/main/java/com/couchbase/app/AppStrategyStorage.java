package com.couchbase.app;

import java.util.HashMap;

public class AppStrategyStorage {
    private static HashMap<String,App> apps = new HashMap<>();

    static
    {
        apps.put("couchbaseil",new App());
        apps.put("couchbasecdc",new App());
    }

    public static void addApp(String dbName , App app)
    {
        apps.put(dbName,app);
    }
    public static App getApp(String key)
    {
        return apps.get(key);
    }
}
