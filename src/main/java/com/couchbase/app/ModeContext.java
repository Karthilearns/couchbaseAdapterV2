package com.couchbase.app;

public class ModeContext
{
    Mode mode;

    public void addReference(Mode mode)
    {
       this.mode = mode;
    }

    public void invoke(AdapterProperties readerProperties, AdapterProperties writerProperties) throws InterruptedException {
        mode.execute(readerProperties,writerProperties);
    }
}
