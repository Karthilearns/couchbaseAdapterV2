package com.couchbase.app;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;

public class CouchBaseWriter implements IWriter{

    Cluster cluster;
    Bucket bucket;

    @Override
    public void initialize(AdapterProperties properties) {
        cluster = Cluster.connect(properties.getProperty("hosturl"),properties.getProperty("username"),properties.getProperty("password"));
        bucket = cluster.bucket(properties.getProperty("bucketname"));

    }

    @Override
    public void write(Event<Object> eventData) {

    }
}
