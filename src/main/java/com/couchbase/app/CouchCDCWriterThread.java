package com.couchbase.app;

import com.couchbase.client.java.json.JsonObject;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

public class CouchCDCWriterThread implements Runnable
{
    App app = new App();
    @Override
    public void run() {
        CouchCDCReader couchBaseApp = new CouchCDCReader();
        while (true)
        {

           BlockingQueue<Event<Object>> events = app.getEvents();

            if(events.size()>0)
            {
                System.out.println("write triggered");
                Event<Object> event = events.remove();
                CouchBaseCDCWriter couchBaseCDCWriter = new CouchBaseCDCWriter();

                couchBaseCDCWriter.write(event);
                System.out.println(event);
            }

        }
    }
}
