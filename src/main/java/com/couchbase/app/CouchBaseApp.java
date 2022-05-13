package com.couchbase.app;

import com.sun.media.sound.ModelSource;

import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CouchBaseApp implements IApp
{
    static IReader reader;
    static IWriter writer;
    static BlockingQueue<Event<Object>> events = new ArrayBlockingQueue<>(50000);
    static String mode;
    public IReader getReader() {
        return reader;
    }

    public static String getMode() {
        return mode;
    }

    public static void setMode(String mode) {
        CouchBaseApp.mode = mode;
    }

    public void setReader(IReader reader) {
        this.reader = reader;
    }

    public IWriter getWriter() {
        return writer;
    }

    public void setWriter(IWriter writer) {
        this.writer = writer;
    }

    public BlockingQueue<Event<Object>> getEvents() {
        return events;
    }

    public void setEvents(BlockingQueue<Event<Object>> events) {
        this.events = events;
    }

    @Override
    public void addReader(IReader reader) {
        this.reader = reader;
    }

    @Override
    public void addWriter(IWriter writer) {

        this.writer = writer;
    }

    @Override
    public void start(AdapterProperties readerProperties , AdapterProperties writerProperties) throws InterruptedException {

            ModeContext context = new ModeContext();
            String requiredMode = readerProperties.getProperty("mode");
            ModeStorage modeStorage = new ModeStorage();
            HashMap<String, Mode> modes = modeStorage.getModes();
            System.out.println(modes.get(requiredMode.toLowerCase(Locale.ROOT)) instanceof CDCMode);

            context.addReference(modes.get(requiredMode.toLowerCase(Locale.ROOT)));
            context.invoke(readerProperties,writerProperties);

    }
}


