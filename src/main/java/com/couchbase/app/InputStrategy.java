package com.couchbase.app;

import java.util.Hashtable;

public interface InputStrategy {
   Hashtable<String, AdapterProperties> execute();
}
