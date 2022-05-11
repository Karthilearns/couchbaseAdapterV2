package com.couchbase.app;

public interface IApp {

    void addReader(IReader reader);

    void addWriter(IWriter writer);

    void start(AdapterProperties source, AdapterProperties target);

}
