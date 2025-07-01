package org.krakn.exercise;

import tuts.common.CalculationTaskC;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolTuningDemo {
    private static final int NUM_TASKS = 1000;

    public static void main(String[] args) {
        runTestWithPoolSize(3);
    }
    public static void xyz(String[] args) {
        System.out.println("====================================");
        System.out.println("# OF THREADS   TIME TAKEN (seconds)");
        System.out.println("====================================");

        int poolSize = 3;
        double previousTime = Double.MAX_VALUE;
        boolean performanceDegraded = false;

        while (!performanceDegraded) {
            double executionTime = runTestWithPoolSize(poolSize);
            System.out.printf("%-14d %.3f%n", poolSize, executionTime);

            // Stop if time increases compared to previous run
            if (executionTime > previousTime) {
                performanceDegraded = true;
            } else {
                previousTime = executionTime;
                poolSize += 3;
            }
        }

        System.out.println("====================================");
        printSystemSpecs();
    }

    private static double runTestWithPoolSize(int poolSize) {
        ExecutorService executor = Executors.newFixedThreadPool(poolSize);
        List<Future<Long>> futures = new ArrayList<>(NUM_TASKS);

        long startTime = System.nanoTime();

        // Submit tasks
        for (int i = 0; i < NUM_TASKS; i++) {
            futures.add(executor.submit(new CalculationTaskC()));
        }

        // Wait for completion
        for (Future<Long> future : futures) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        long endTime = System.nanoTime();
        executor.shutdown();

        return (endTime - startTime) / 1_000_000_000.0;
    }

    private static void printSystemSpecs() {
        System.out.println("Laptop Name/Model : " + System.getProperty("os.name"));
        System.out.println("Processor Make    : " + System.getenv("PROCESSOR_IDENTIFIER"));
        System.out.println("# of cores       : " + Runtime.getRuntime().availableProcessors());
        System.out.println("RAM               : " + (Runtime.getRuntime().totalMemory() >> 20) + " MB");
    }
}
