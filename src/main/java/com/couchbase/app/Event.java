package com.couchbase.app;

public class Event<T> {
    T record;
    String metaData;

    public Event(T record, String metaData) {
        this.record = record;
        this.metaData = metaData;
    }

    public T getRecord() {
        return record;
    }

    public void setRecord(T record) {
        this.record = record;
    }

    public String getMetaData() {
        return metaData;
    }

    public void setMetaData(String metaData) {
        this.metaData = metaData;
    }

    @Override
    public String toString() {
        return "Event{" +
                "record=" + record +
                ", metaData='" + metaData + '\'' +
                '}';
    }
}
