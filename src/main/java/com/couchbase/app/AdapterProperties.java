package com.couchbase.app;

import java.util.HashMap;
import java.util.Hashtable;

public class AdapterProperties {
    private HashMap<String ,String> adapterCredentials = new HashMap<>();
    AdapterProperties()
    {
        adapterCredentials.put("databasename",null);
        adapterCredentials.put("username",null);
        adapterCredentials.put("bucketname",null);
        adapterCredentials.put("password",null);
        adapterCredentials.put("hosturl",null);
        adapterCredentials.put("mode",null);

    }

    public void addProperties(String key , String value)
    {
            adapterCredentials.put(key,value);
    }

    public String getProperty(String key)
    {
        if(adapterCredentials.containsKey(key))
        {
            return adapterCredentials.get(key);
        }
        else {
            System.out.println("value doesnt exists");
        }
        return null;
    }
    public HashMap<String,String> getAllProperties()
    {
        return adapterCredentials;
    }

}
