package com.couchbase.app;

public interface IReader{
    void initialize(AdapterProperties properties) throws InterruptedException;
    Event<Object> read() throws InterruptedException;

}
