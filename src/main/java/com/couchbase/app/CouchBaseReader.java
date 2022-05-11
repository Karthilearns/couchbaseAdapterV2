package com.couchbase.app;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.Collection;

public class CouchBaseReader implements IReader{

    Bucket bucket;

    @Override
    public void initialize(AdapterProperties properties) {
        Cluster cluster = Cluster.connect(properties.getProperty("hosturl"),properties.getProperty("username"),properties.getProperty("password"));
        bucket = cluster.bucket(properties.getProperty("bucketname"));
    }

    @Override
    public Event<Object> read() {
        return null;
    }


}
