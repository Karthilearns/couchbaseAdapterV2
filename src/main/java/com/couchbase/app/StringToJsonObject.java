package com.couchbase.app;

import com.couchbase.client.java.json.JsonObject;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;

public class StringToJsonObject {
    String word;
    String elements[];

    HashMap<String,String> mapToReturn = new LinkedHashMap<>();
    StringToJsonObject(String word)
    {
        this.word = word;
    }
    public String convert( )
    {

        word = word.substring(15,word.length());
        word.trim();
        word = word.substring(2,word.length()-1);
        word+="}";
        word = "{"+word;
        return word;
    }

    public HashMap<String,String> exe()
    {
        elements = word.split(",");
        for(String s : elements)
       {
           String kv[] = s.split(":");
           mapToReturn.put(kv[0],kv[1]);
        }
        return mapToReturn;
    }
//    public HashMap<String,String> execute()
//    {
//        for(String s : elements)
//        {
//           String kv[] = s.split(":");
//           mapToReturn.put(kv[0],kv[1]);
//        }
//        return mapToReturn;
//    }



}
