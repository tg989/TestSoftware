package com.testprogram;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(String[] args) {
        // Conduct tests & Generate report here
//        Result result = JUnitCore.runClasses(DriverTest.class);
//
//        System.out.println("Is the test successful?: " + result.wasSuccessful());
//
//        for (Failure failure : result.getFailures()) {
//            System.out.println("Failure: " + failure.toString());
//        }
        
        // Conduct tests & Generate report here
        Result mergeResult = JUnitCore.runClasses(MergeSortTest.class);

        System.out.println("Is the mergesort test successful?: " + mergeResult.wasSuccessful());

        for (Failure failure : mergeResult.getFailures()) {
            System.out.println("Failure: " + failure.toString());
        }
    }
}
