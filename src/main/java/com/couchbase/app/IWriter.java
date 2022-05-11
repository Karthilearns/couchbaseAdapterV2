package com.couchbase.app;

public interface IWriter {
    void initialize(AdapterProperties properties);
    void write(Event<Object> eventData);

}
