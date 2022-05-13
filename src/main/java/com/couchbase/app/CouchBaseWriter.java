package com.couchbase.app;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.Collection;
import com.couchbase.client.java.json.JsonObject;

public class CouchBaseWriter implements IWriter
{

    Cluster cluster;
    Bucket bucket;

    @Override
    public void initialize(AdapterProperties properties)
    {
        cluster = Cluster.connect(properties.getProperty("hosturl"),properties.getProperty("username"),properties.getProperty("password"));
        bucket = cluster.bucket(properties.getProperty("bucketname"));
    }

    @Override
    public void write(Event<Object> eventData) {
        Collection  collection = bucket.defaultCollection();
        JsonObject  metaData = JsonObject.fromJson(eventData.getMetaData());
        collection.upsert(metaData.getString("id"),eventData.getRecord());
    }
}
