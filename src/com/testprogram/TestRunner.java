package com.testprogram;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

    public static void main(String[] args) {
        // Conduct tests & Generate report here
        if (args[0] == "test") {
            if(args[1] == "driver") { // Runs only driver tests
                Result result = JUnitCore.runClasses(DriverTest.class);

                System.out.println("Is the test successful?: " + result.wasSuccessful());

                for (Failure failure : result.getFailures()) {
                    System.out.println("Failure: " + failure.toString());
                }
            } else if(args[1] == "sort") { // Runs only merge sort tests
                Result result2 = JUnitCore.runClasses(MergeSortTest.class);

                System.out.println("Is the test successful?: " + result2.wasSuccessful());

                for (Failure failure : result2.getFailures()) {
                    System.out.println("Failure: " + failure.toString());
                }
            } else { // Runs Both Test
                Result result = JUnitCore.runClasses(DriverTest.class);

                System.out.println("Is the test successful?: " + result.wasSuccessful());

                for (Failure failure : result.getFailures()) {
                    System.out.println("Failure: " + failure.toString());
                }

                Result result2 = JUnitCore.runClasses(MergeSortTest.class);

                System.out.println("Is the test successful?: " + result2.wasSuccessful());

                for (Failure failure : result2.getFailures()) {
                    System.out.println("Failure: " + failure.toString());
                }
            }
        } else { // Running Program generally
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

    }
}
