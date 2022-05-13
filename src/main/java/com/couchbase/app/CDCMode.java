package com.couchbase.app;

public class CDCMode implements Mode{

    CouchBaseApp couchBaseApp = new CouchBaseApp();
    IWriter writer = couchBaseApp.getWriter();
    IReader reader = couchBaseApp.getReader();
    @Override
    public void execute(AdapterProperties readerProperties, AdapterProperties writerProperties)
    {
        System.out.println("CDCmode excute triggered");
        writer.initialize(readerProperties);
        reader.initialize(writerProperties);

    }
}
