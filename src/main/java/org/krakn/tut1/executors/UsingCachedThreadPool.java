package org.krakn.tut1.executors;

import org.krakn.tuts.common.LoopTaskA;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingCachedThreadPool {
    public static void main(String[] args) {
        System.out.println("Main Thread starts here...");
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i=6;i>0;i--){
            executorService.submit(new LoopTaskA());
        }
        executorService.shutdown();
        System.out.println("Main Thread ends here...");
    }
}
