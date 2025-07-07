package org.krakn.tut2.executors.naming;

import org.krakn.tuts.common.LoopTaskC;
import org.krakn.tuts.common.NamedThreadsFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class UsingCachedThreadPool_Part2 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread starts here...");
        ExecutorService service = Executors.newCachedThreadPool(new NamedThreadsFactory());
        for(int i=0;i<3;i++){
            service.submit(new LoopTaskC());
        }
        TimeUnit.SECONDS.sleep(10);
        for(int i=0;i<5;i++){
            service.submit(new LoopTaskC());
        }
        service.shutdown();
        System.out.println("Main thread ends here...");
    }
}
