package com.couchbase.app;

import java.util.HashMap;

public class ReaderStorage {
    static HashMap<String , IReader> readers = new HashMap<>();

    static {
        readers.put("couchbaseil",new CouchBaseReader());
        readers.put("couchbasecdc",new CouchCDCReader());
    }

    public static IReader getReader(String databaseName)
    {
        return readers.get(databaseName);
    }
    public static void addReader(String databaseName , IReader reader)
    {
        readers.put(databaseName,reader);
    }

}
