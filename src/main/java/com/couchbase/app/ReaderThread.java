package com.couchbase.app;

public class ReaderThread implements Runnable{

    @Override
    public void run() {

        // thread loop
        while (true) {
            CouchBaseApp app = new CouchBaseApp();
            IReader reader = app.getReader();
            Event<Object> event = null;
            try {
                event = reader.read();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                app.getEvents().put(event);
                System.out.println(app.events.size());
                System.out.println(event);
                }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
