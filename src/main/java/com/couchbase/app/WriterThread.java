package com.couchbase.app;

public class WriterThread implements Runnable
{

    @Override
    public void run() {
        while(true)
        {
            CouchBaseApp couchBaseApp = new CouchBaseApp();
            IWriter writer =  null;
            Event<Object> eventToWrite =null;
            if(couchBaseApp.getEvents().size()>0) {
                writer = couchBaseApp.getWriter();
                eventToWrite = couchBaseApp.getEvents().remove();
            }
            if(eventToWrite != null){
                writer.write(eventToWrite);
            }
        }
    }
}
