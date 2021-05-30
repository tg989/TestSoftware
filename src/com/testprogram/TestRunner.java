package com.testprogram;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

    public static void main(String[] args) {
        // Conduct tests & Generate report here
        System.out.println("---------------------------------------------------------------------------------");
        if(args.length == 0) { // Running Program generally
            System.out.println("PROGRAM RUNNING:");
            runGenerally();
        } else if (args[0].equals("test")) {
            if(args.length == 1) { // Runs Both Test
                System.out.println("WHOLE PROGRAM TEST REPORT:");
                runDriverTests();
                runSortTests();
            } else if(args[1].equals("sort")) { // Runs only merge sort tests
                System.out.println("MERGE SORT TEST REPORT:");
                runSortTests();
            } else if (args[1].equals("driver")) { // Runs only driver tests
                System.out.println("DRIVER TEST REPORT:");
                runDriverTests();
            }
        }

    }

    public static void runGenerally() {
        System.out.println("---------------------------------------------------------------------------------");
        Driver driver = new Driver();
        if (driver.readFile()) {
            System.out.println("File correctly read in");
        } else {
            System.out.println("Error reading file");
        }
        Driver.getMergeSort().mergeSortWordArray();
        System.out.println("Words sorted");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("PROGRAM OUTPUT: ");
        System.out.println("Head: \n" + driver.printHead(Driver.getMergeSort().getWordArray(), Driver.getMergeSort().getWordMap()));
        System.out.println("Tail: \n" + driver.printTail(Driver.getMergeSort().getWordArray(), Driver.getMergeSort().getWordMap(), Driver.getMergeSort().getIndex()));
        System.out.println("---------------------------------------------------------------------------------");
    }

    public static void runDriverTests() {
        Result result = JUnitCore.runClasses(DriverTest.class);
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Are the tests successful?: " + result.wasSuccessful());
        System.out.println("---------------------------------------------------------------------------------");
        for (Failure failure : result.getFailures()) {
            System.out.println("Failure: " + failure.toString());
        }
    }

    public static void runSortTests() {
        Result result2 = JUnitCore.runClasses(MergeSortTest.class);
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Are the tests successful?: " + result2.wasSuccessful());
        System.out.println("---------------------------------------------------------------------------------");
        for (Failure failure : result2.getFailures()) {
            System.out.println("Failure: " + failure.toString());
        }
    }
}
