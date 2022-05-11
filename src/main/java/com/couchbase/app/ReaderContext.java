package com.couchbase.app;

public class ReaderContext {
    IReader reader;

    public void addReader(IReader _reader)
    {
        reader = _reader;
    }


}
