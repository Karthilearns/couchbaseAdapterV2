package com.couchbase.app;

import java.util.HashMap;

public class AppStrategyStorage {
    private static HashMap<String,IApp> apps = new HashMap<>();

    static
    {
        apps.put("couchbasecdc",new CouchBaseApp());
        apps.put("couchbaseil",new CouchBaseApp());
    }

    public static void addApp(String dbName , IApp app)
    {
        apps.put(dbName,app);
    }
    public static IApp getApp(String key)
    {
        return apps.get(key);
    }
}
