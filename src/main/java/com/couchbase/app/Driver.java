package com.couchbase.app;

import java.util.Locale;
import java.util.Scanner;

public class Driver {
    public static void main(String args[])
    {
        // getting input starts here
        Scanner scanner = new Scanner(System.in);

        StandardOutputs.printForUserModeChoice();
        int userChoice = scanner.nextInt();

        InputStrategy inputStrategy = InputStrategyStorage.getStrategy(userChoice);
        InputContext inputContext = new InputContext();
        inputContext.addStrategyImplementation(inputStrategy);
        AdapterProperties sourceAdapterProperties = inputContext.invoke();
        AdapterProperties targetAdapterProperties = inputContext.invoke();
        // getting input ends here

        String sourceDatabaseName  = sourceAdapterProperties.getProperty("databasename");
        String targetDatabaseName = targetAdapterProperties.getProperty("databasename");

        IReader reader = ReaderStorage.getReader(sourceDatabaseName);
        IWriter writer = WriterStorage.getWriter(targetDatabaseName);


        IApp app = AppStrategyStorage.getApp(sourceDatabaseName.toLowerCase(Locale.ROOT));
        app.addWriter(writer);
        app.addReader(reader);
        app.start(sourceAdapterProperties,targetAdapterProperties);



    }
}
