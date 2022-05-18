package com.couchbase.app;

import com.couchbase.client.dcp.Client;
import com.couchbase.client.dcp.DataEventHandler;
import com.couchbase.client.dcp.StreamFrom;
import com.couchbase.client.dcp.StreamTo;
import com.couchbase.client.dcp.deps.io.netty.buffer.ByteBuf;
import com.couchbase.client.dcp.message.DcpDeletionMessage;
import com.couchbase.client.dcp.message.DcpMutationMessage;
import com.couchbase.client.dcp.transport.netty.ChannelFlowController;
import com.couchbase.client.java.json.JsonObject;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

public class CouchCDC {
    public void captureAndLoad(AdapterProperties sourceProperties) throws InterruptedException {
        Client client =  Client.builder().seedNodes(sourceProperties.getProperty("hosturl"))
                .bucket(sourceProperties.getProperty("bucketname"))
                .credentials(sourceProperties.getProperty("username"),sourceProperties.getProperty("password"))
                .build();
        App app = new App();
        client.dataEventHandler(new DataEventHandler() {

            @Override
            public void onEvent(ChannelFlowController flowController, ByteBuf event) {
                if(DcpMutationMessage.is(event))
                {


                    String key = DcpMutationMessage.keyString(event);
                    String value = DcpMutationMessage.content(event).toString(StandardCharsets.UTF_8);
                    String metaData = DcpMutationMessage.toString(event);
                    Event<Object> eventToemit = new Event<>(JsonObject.create().put(key,value),metaData);
                    System.out.println(eventToemit);
                    System.out.println(DcpMutationMessage.toString(event));
                    System.out.println("key "+key);
                    System.out.println("value "+value);
                    JsonObject jsonObject = JsonObject.fromJson(value);
                    System.out.println(jsonObject);

                    try {
                        app.addEvent(new Event<Object>(jsonObject,metaData));
                        System.out.println(app.getEvents().size());
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
//                    // CouchCDCReader couchBaseReader = new CouchCDCReader();
//                   //  couchBaseReader.getEvents().add(eventToemit);
//                  //   System.out.println(couchBaseReader.getEvents().size());


                }
                else if(DcpDeletionMessage.is(event)){

                }
            }
        });

        client.connect().block();

        client.initializeState(StreamFrom.NOW, StreamTo.INFINITY).block();

        client.startStreaming().block();

        Thread.sleep(TimeUnit.MINUTES.toMillis(1000));

        client.disconnect().block();
    }

//    public Event<Object> emitEvent(Event<Object> event)
//    {
//         return  event;
//    }

}
