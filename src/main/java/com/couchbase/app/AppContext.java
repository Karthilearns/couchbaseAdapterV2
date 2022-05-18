package com.couchbase.app;

public class AppContext {
    private App appReference;

    public void addReference(App app)
    {
        appReference = app;
    }

    public void invoke()
    {
    //    appReference.start();
    }

}
