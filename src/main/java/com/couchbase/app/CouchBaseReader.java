package com.couchbase.app;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.json.JsonObject;
import com.couchbase.client.java.query.QueryResult;

import java.util.List;

public class CouchBaseReader implements IReader{

    Cluster cluster;
    Bucket bucket;
    static int cursor =0;

    @Override
    public void initialize(AdapterProperties properties)
    {
        cluster = Cluster.connect(properties.getProperty("hosturl"),properties.getProperty("username"),properties.getProperty("password"));
        bucket = cluster.bucket(properties.getProperty("bucketname"));
    }

    @Override
    public Event<Object> read() {

      QueryResult queryResult = cluster.query("select *,meta() as meta from "+ bucket.name()+" as record");
      List<JsonObject> queryResultList = queryResult.rowsAsObject();
//      for(JsonObject  jsonObject : queryResultList)
//      {
//          Event<Object> event = new Event<Object>(jsonObject.get("record"),jsonObject.get("meta").toString());
//          System.out.println(event);
//      }
        if(cursor<queryResultList.size()) {
            JsonObject jsonObject = queryResultList.get(cursor++);
            Event<Object> event = new Event<>(jsonObject.get("record"), jsonObject.get("meta").toString());
            return event;
        }
        else {
            Thread.currentThread().stop();
        }
        return null;
    }


}
