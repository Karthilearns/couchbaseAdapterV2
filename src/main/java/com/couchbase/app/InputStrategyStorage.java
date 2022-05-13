package com.couchbase.app;

import java.util.Hashtable;

public class InputStrategyStorage {
    private static Hashtable<Integer, InputStrategy> strategies = new Hashtable<>();

    static
    {
        strategies.put(1,new InitialLoadStrategy());

    }
    public static void addStrategy(InputStrategy inputStrategy)
    {
        strategies.put(strategies.size(),inputStrategy);
    }

    public static InputStrategy getStrategy(int key)
    {
        return strategies.get(key);
    }
}
