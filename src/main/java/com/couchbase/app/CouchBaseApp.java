package com.couchbase.app;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CouchBaseApp implements IApp
{
    IReader reader;
    IWriter writer;
    BlockingQueue<Event<Object>> events = new ArrayBlockingQueue<>(10);


    @Override
    public void addReader(IReader reader) {
        this.reader = reader;
    }

    @Override
    public void addWriter(IWriter writer) {

        this.writer = writer;
    }

    @Override
    public void start(AdapterProperties readerProperties , AdapterProperties writerProperties) {

        reader.initialize(readerProperties);
        writer.initialize(writerProperties);
        Event<Object> event = reader.read();


    }
}


