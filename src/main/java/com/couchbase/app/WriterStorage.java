package com.couchbase.app;

import java.util.HashMap;

public class WriterStorage {
    static  HashMap<String,IWriter> writers = new HashMap<>();
    static {
        writers.put("couchbaseil",new CouchBaseWriter());
        writers.put("couchbasecdc",new CouchBaseCDCWriter());
    }

    public static IWriter getWriter(String databaseName)
    {
        return writers.get(databaseName);
    }

    public static void addWriter(String databaseName , IWriter writer)
    {
        writers.put(databaseName,writer);
    }
}
