package com.couchbase.app;

public class AppContext {
    private IApp appReference;

    public void addReference(IApp app)
    {
        appReference = app;
    }

    public void invoke()
    {
    //    appReference.start();
    }

}
