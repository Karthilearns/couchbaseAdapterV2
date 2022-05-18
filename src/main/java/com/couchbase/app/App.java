package com.couchbase.app;

import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App
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
        App.mode = mode;
    }

    public void setReader(IReader reader) {
        this.reader = reader;
    }

    public void addEvent(Event<Object> event) throws InterruptedException {
        events.put(event);
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


    public void addReader(IReader reader) {
        this.reader = reader;
    }


    public void addWriter(IWriter writer) {

        this.writer = writer;
    }


    public void start(AdapterProperties readerProperties , AdapterProperties writerProperties) throws InterruptedException {

            ModeContext modeContext = new ModeContext();
            String requiredMode = readerProperties.getProperty("mode");
            ModeStorage modeStorage = new ModeStorage();
            HashMap<String, Mode> modes = modeStorage.getModes();
            System.out.println(modes.get(requiredMode.toLowerCase(Locale.ROOT)) instanceof CDCMode);

            modeContext.addReference(modes.get(requiredMode.toLowerCase(Locale.ROOT)));
            modeContext.invoke(readerProperties,writerProperties);
    }
}


