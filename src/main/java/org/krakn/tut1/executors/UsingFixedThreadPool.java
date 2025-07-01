package org.krakn.tut1.executors;

import org.krakn.exercise.tuts.common.LoopTaskA;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingFixedThreadPool {
    public static void main(String[] args) {
        System.out.println("Main Thread starts here...");
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i=6;i>0;i--){
            executorService.submit(new LoopTaskA());
        }
        executorService.shutdown();
        System.out.println("Main Thread ends here...");
    }
}
