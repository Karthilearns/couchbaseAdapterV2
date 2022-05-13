package com.couchbase.app;

public interface ChangeDataCapture {
    void captureAndLoad(AdapterProperties sourceProperties) throws InterruptedException;
}
