package com.couchbase.app;

import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class InitialLoadStrategy implements InputStrategy {

    Hashtable<String, AdapterProperties> adapterPropertiesTable = new Hashtable<>();

    @Override
    public Hashtable<String, AdapterProperties> execute() {

        Scanner scanner = new Scanner(System.in);

        boolean flag = true;
        for (int i = 0; i < 2; i++) {
            AdapterProperties adapterProperties = new AdapterProperties();
            while (flag) {
                StandardOutputs.printForKeyInput();
                String key = scanner.next().toLowerCase(Locale.ROOT);
                StandardOutputs.printForValueInput();
                String value = scanner.next();
                adapterProperties.addProperties(key, value);
                flag = scanner.nextBoolean();
            }
            if (adapterPropertiesTable.size() == 0) {
                adapterPropertiesTable.put("sourceAdapterProperties", adapterProperties);
            } else {
                adapterPropertiesTable.put("targetAdapterProperties", adapterProperties);
            }
            flag = true;
        }
        return adapterPropertiesTable;
    }
}

