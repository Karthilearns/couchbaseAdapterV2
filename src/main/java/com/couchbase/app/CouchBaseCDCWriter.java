package com.couchbase.app;

import com.couchbase.client.dcp.deps.com.fasterxml.jackson.core.JsonParser;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.Collection;
import com.couchbase.client.java.json.JsonObject;
import jdk.nashorn.internal.parser.JSONParser;

import java.util.HashMap;
import java.util.concurrent.BlockingQueue;

public class CouchBaseCDCWriter implements IWriter{

    static AdapterProperties properties;
    static  Cluster cluster;
    static  Bucket bucket;
    @Override
    public void initialize(AdapterProperties properties) {
        this.properties = properties;
        System.out.print("proper null");
        System.out.println(this.properties == null );
        cluster = Cluster.connect(properties.getProperty("hosturl"),properties.getProperty("username"),properties.getProperty("password"));
        bucket = cluster.bucket(properties.getProperty("bucketname"));
        System.out.println("is bucket init ") ;
        System.out.println(bucket==null);
    }
    @Override
    public void write(Event<Object> eventData) {

        System.out.println(properties==null);
        System.out.println(bucket == null);
        System.out.println(cluster == null);
        JsonObject record = (JsonObject) eventData.record;
        System.out.println("meta data = "+ eventData.getMetaData());
        FindKey findKey = new FindKey();
        String key  = findKey.find(eventData.getMetaData());
        System.out.println(key);
//       // JsonObject metaData = JsonObject.fromJson(eventData.metaData);
//
//       // JsonObject metaData = eventData.getMetaData();
//        StringToJsonObject converter = new StringToJsonObject(eventData.getMetaData());
//        System.out.println(eventData.getMetaData());
//        String toConvert = converter.convert();
//        System.out.println(toConvert);
//        //JsonObject metaData = JsonObject.fromJson(toConvert);
//       // JsonObject.from();
        Collection collection = bucket.defaultCollection();
//        StringToJsonObject j = new StringToJsonObject(toConvert);
//        HashMap<String,String> s = j.exe();
//        JsonObject jsonObject = JsonObject.from(s);
//        System.out.println(jsonObject);
//        System.out.println(jsonObject.getString("key"));
//        System.out.println(eventData.getRecord());
        collection.upsert(key,(JsonObject)eventData.getRecord());
        System.out.println("upserted");

    }

}
