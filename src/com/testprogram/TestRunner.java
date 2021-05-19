package com.testprogram;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(String[] args) {
        // Running Program generally
        Driver driver = new Driver();
        if (driver.readFile()) {
            System.out.println("RIGHTO");
        } else {
            System.out.println("This wrong");
        }
        Driver.getMergeSort().mergeSortWordArray();
        driver.printHead();
        driver.printTail();

        // Conduct tests & Generate report here
        Result result = JUnitCore.runClasses(Driver.class);

        System.out.println("Is the test successful?: " + result.wasSuccessful());

        for (Failure failure : result.getFailures()) {
            System.out.println("Failure: " + failure.toString());
        }
    }

}
