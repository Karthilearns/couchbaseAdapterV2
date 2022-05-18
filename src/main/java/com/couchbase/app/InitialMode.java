package com.couchbase.app;

public class InitialMode implements Mode{

    App couchBaseApp = new App();
    IWriter writer = couchBaseApp.getWriter();
    IReader reader = couchBaseApp.getReader();

    @Override
    public void execute(AdapterProperties readerProperties, AdapterProperties writerProperties) throws InterruptedException
    {
        reader.initialize(readerProperties);
        writer.initialize(writerProperties);
        System.out.println("start initialize");
        Thread.sleep(3000);
        Thread writerThread =  new Thread(new WriterThread());
        Thread readerThread =  new Thread(new ReaderThread());
        readerThread.start();
        writerThread.start();

    }
}
