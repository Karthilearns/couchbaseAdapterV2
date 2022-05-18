package com.couchbase.app;

public class WriterThread implements Runnable
{

    @Override
    public void run() {
        while(true)
        {
            App app = new App();
            IWriter writer =  null;
            Event<Object> eventToWrite =null;
            if(app.getEvents().size()>0) {
                writer = app.getWriter();
                eventToWrite = app.getEvents().remove();
            }
            if(eventToWrite != null){
                writer.write(eventToWrite);
            }
        }
    }

}
