package com.couchbase.app;

import java.util.Hashtable;

public class InputContext {
    private InputStrategy strategyReference;

    public void addStrategyImplementation(InputStrategy inputStrategy)
    {
        this.strategyReference = inputStrategy;
    }

    public Hashtable<String, AdapterProperties> invoke()
    {
        Hashtable<String, AdapterProperties> adapterProperties = strategyReference.execute();
        return  adapterProperties;
    }

}
