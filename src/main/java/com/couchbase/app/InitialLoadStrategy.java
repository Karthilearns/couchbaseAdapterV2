package com.couchbase.app;

import java.util.Locale;
import java.util.Scanner;

public class InitialLoadStrategy implements InputStrategy{

    @Override
    public AdapterProperties execute() {

        Scanner scanner = new Scanner(System.in);
        AdapterProperties adapterProperties = new AdapterProperties();
        boolean flag = true;
        while(flag)
        {

            StandardOutputs.printForKeyInput();
            String key = scanner.next().toLowerCase(Locale.ROOT);
            StandardOutputs.printForValueInput();
            String value = scanner.next().toLowerCase(Locale.ROOT);
            adapterProperties.addProperties(key,value);
            flag = scanner.nextBoolean();
        }
        return adapterProperties;
    }
}
