package com.couchbase.app;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Scanner;

public class Driver {
    public static void main(String args[]) throws InterruptedException {

        // getting input starts here
        Scanner scanner = new Scanner(System.in);

        StandardOutputs.printForUserModeChoice();
        int userChoice = scanner.nextInt();

        InputStrategy inputStrategy = InputStrategyStorage.getStrategy(userChoice);
        InputContext inputContext = new InputContext();
        inputContext.addStrategyImplementation(inputStrategy);
        Hashtable<String,AdapterProperties> adapterProperties = inputContext.invoke();

        String sourceDatabaseName  = adapterProperties.get("sourceAdapterProperties").getProperty("databasename")+adapterProperties.get("sourceAdapterProperties").getProperty("mode");
        System.out.println(sourceDatabaseName);
        String targetDatabaseName =  adapterProperties.get("targetAdapterProperties").getProperty("databasename")+adapterProperties.get("targetAdapterProperties").getProperty("mode");
        System.out.println(targetDatabaseName);
        IReader reader = ReaderStorage.getReader(sourceDatabaseName);
        IWriter writer = WriterStorage.getWriter(targetDatabaseName);

        System.out.println(reader instanceof CouchCDCReader);
        System.out.println(writer instanceof CouchBaseCDCWriter);

        App app = AppStrategyStorage.getApp(sourceDatabaseName.toLowerCase(Locale.ROOT));
        app.addWriter(writer);
        app.addReader(reader);
        app.start(adapterProperties.get("sourceAdapterProperties"),adapterProperties.get("targetAdapterProperties"));

    }
}
