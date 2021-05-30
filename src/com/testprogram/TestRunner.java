package com.testprogram;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

    public static void main(String[] args) {
        // Conduct tests & Generate report here
        if(args.length == 0) { // Running Program generally
            runGenerally();
        } else if (args[0].equals("test")) {
            if(args.length == 1) { // Runs Both Test
                runDriverTests();
                runSortTests();
            } else if(args[1].equals("sort")) { // Runs only merge sort tests
                runSortTests();
            } else if (args[1].equals("driver")) { // Runs only driver tests
                runDriverTests();
            }
        }

    }

    public static void runGenerally() {
        Driver driver = new Driver();
        if (driver.readFile()) {
            System.out.println("RIGHTO");
        } else {
            System.out.println("This wrong");
        }
        Driver.getMergeSort().mergeSortWordArray();
        driver.printHead(Driver.getMergeSort().getWordArray(), Driver.getMergeSort().getWordMap());
        driver.printTail(Driver.getMergeSort().getWordArray(), Driver.getMergeSort().getWordMap(), Driver.getMergeSort().getIndex());
    }

    public static void runDriverTests() {
        Result result = JUnitCore.runClasses(DriverTest.class);

        System.out.println("Is the test successful?: " + result.wasSuccessful());

        for (Failure failure : result.getFailures()) {
            System.out.println("Failure: " + failure.toString());
        }
    }

    public static void runSortTests() {
        Result result2 = JUnitCore.runClasses(MergeSortTest.class);

        System.out.println("Is the test successful?: " + result2.wasSuccessful());

        for (Failure failure : result2.getFailures()) {
            System.out.println("Failure: " + failure.toString());
        }
    }
}
