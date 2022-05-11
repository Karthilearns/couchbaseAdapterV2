package com.couchbase.app;

public class InputContext {
    private InputStrategy strategyReference;

    public void addStrategyImplementation(InputStrategy inputStrategy)
    {
        this.strategyReference = inputStrategy;
    }

    public AdapterProperties invoke()
    {
        AdapterProperties adapterProperties = strategyReference.execute();
        return  adapterProperties;
    }

}
