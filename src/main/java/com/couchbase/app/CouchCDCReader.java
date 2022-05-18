package com.couchbase.app;


import java.util.ArrayList;

public class CouchCDCReader implements IReader{
   // Cluster cluster;
   // Bucket bucket;
    AdapterProperties adapterProperties ;
    static private ArrayList<Event<Object>> events = new ArrayList<>();

    public AdapterProperties getAdapterProperties() {
        return adapterProperties;
    }

    public void setAdapterProperties(AdapterProperties adapterProperties) {
        this.adapterProperties = adapterProperties;
    }

    public ArrayList<Event<Object>> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event<Object>> events) {
        this.events = events;
    }

    @Override
    public void initialize(AdapterProperties properties) throws InterruptedException {
        adapterProperties = properties;
        System.out.println("cdc reader init");

  //      cluster = Cluster.connect(properties.getProperty("hosturl"),properties.getProperty("username"),properties.getProperty("password"));
  //      bucket = cluster.bucket(properties.getProperty("bucketname"));
    }
    @Override
    public Event<Object> read() throws InterruptedException {
        CouchCDC couchCDC = new CouchCDC();
        couchCDC.captureAndLoad(adapterProperties);
        return  null;
    }
}
