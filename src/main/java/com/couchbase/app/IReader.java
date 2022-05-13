package com.couchbase.app;

public interface IReader{
    void initialize(AdapterProperties properties);
    Event<Object> read() throws InterruptedException;

}
