package org.krakn.tuts.common;

import java.util.concurrent.TimeUnit;

public class LoopTaskC implements Runnable{
    private static int count = 0;
    private int instanceNumber;
    private String taskId;
    public LoopTaskC(){
        this.instanceNumber = ++count;
        this.taskId = "LoopTaskC " + instanceNumber;
    }
    @Override
    public void run(){

        System.out.println("##### [" + Thread.currentThread().getName() +"] <" + taskId + "> STARTING #####");
        for(int i=10;i>0;i--){
            System.out.println("[" + Thread.currentThread().getName() + "] <" + taskId + "> TICK TICK - " + i);
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("***** [" + Thread.currentThread().getName() +"] <" + taskId + "> COMPLETED *****");
    }

}


