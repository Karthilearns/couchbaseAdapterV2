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

//        boolean flag = true;
//        for (int i = 0; i < 2; i++) {
//            AdapterProperties adapterProperties = new AdapterProperties();
//            while (flag) {
//                StandardOutputs.printForKeyInput();
//                String key = scanner.next().toLowerCase(Locale.ROOT);
//                StandardOutputs.printForValueInput();
//                String value = scanner.next();
//                adapterProperties.addProperties(key, value);
//                flag = scanner.nextBoolean();
//            }
//            if (adapterPropertiesTable.size() == 0) {
//                adapterPropertiesTable.put("sourceAdapterProperties", adapterProperties);
//            } else {
//                adapterPropertiesTable.put("targetAdapterProperties", adapterProperties);
//            }
//            flag = true;
//        }

        AdapterProperties adapterProperties1  =  new AdapterProperties();
        adapterProperties1.addProperties("hosturl","localhost");
        adapterProperties1.addProperties("username","admin");
        adapterProperties1.addProperties("password","Saibaba@09");
        adapterProperties1.addProperties("bucketname","TESTBUCKET4");
        adapterProperties1.addProperties("databasename","couchbaseIL");
        adapterProperties1.addProperties("mode","il");

        System.out.println("hi");
        AdapterProperties adapterProperties2  =  new AdapterProperties();
        adapterProperties2.addProperties("hosturl","localhost");
        adapterProperties2.addProperties("username","admin");
        adapterProperties2.addProperties("password","Saibaba@09");
        adapterProperties2.addProperties("bucketname","TESTBUCKET6");
        adapterProperties2.addProperties("databasename","couchbaseIL");
        adapterProperties1.addProperties("mode","il");


        adapterPropertiesTable.put("sourceAdapterProperties", adapterProperties1);
        adapterPropertiesTable.put("targetAdapterProperties", adapterProperties2);



        return adapterPropertiesTable;
    }
}

