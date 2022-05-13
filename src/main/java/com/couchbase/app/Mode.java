package com.couchbase.app;

public interface Mode {
    void execute(AdapterProperties readerProperties, AdapterProperties writerProperties) throws InterruptedException;
}
