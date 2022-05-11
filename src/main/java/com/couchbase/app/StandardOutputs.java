package com.couchbase.app;

public class StandardOutputs {
    public static void printForUserChoice()
    {
        System.out.println("ENTER 1 FOR INITIAL LOAD REPLICATION");
        System.out.println("ENTER 2 FOR INCREMENTAL LOAD REPLICATION");
        System.out.println("ENTER 3 FOR SYSOUT");
        System.out.println("ENTER 4 FOR MULTIREADER");
    }

    public  static  void printForKeyInput()
    {
        System.out.println("ENTER KEY FOR THE CREDENTIAL");
    }

    public static void printForValueInput() {
        System.out.println("ENTER VALUE FOR THE CREDENTIAL");
    }

    public static void printForUserModeChoice() {
        System.out.println("ENTER 1 FOR INITIAL LOAD REPLICATION");
        System.out.println("ENTER 2 FOR INCREMENTAL LOAD REPLICATION");
        System.out.println("ENTER 3 FOR SYSOUT");
        System.out.println("ENTER 4 FOR MULTIREADER");
    }
}
