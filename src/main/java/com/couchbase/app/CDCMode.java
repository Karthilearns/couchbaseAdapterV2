package com.couchbase.app;

public class CDCMode implements Mode{

    App app = new App();
    IWriter writer = app.getWriter();
    IReader reader = app.getReader();
    @Override
    public void execute(AdapterProperties readerProperties, AdapterProperties writerProperties) throws InterruptedException {
        System.out.println("CDCmode excute triggered");
        // reader.initialize(readerProperties);
        System.out.println(writer instanceof CouchBaseCDCWriter);
        System.out.println(reader instanceof  CouchCDCReader);
        System.out.println("is writer null ");
        writer.initialize(writerProperties);

        System.out.println("hrllo world");
        System.out.println(writer instanceof  CouchBaseCDCWriter);
        Thread writerThread = new Thread(new CouchCDCWriterThread());
        System.out.println("writer thread started");
        writerThread.start();
        CouchCDC couchCDC = new CouchCDC();
        System.out.println("after start");
        couchCDC.captureAndLoad(readerProperties);
    }
}
