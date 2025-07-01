package org.krakn.tuts.common;

import java.util.concurrent.TimeUnit;

public class LoopTaskB implements Runnable{
    private static int count = 0;
    private int instanceNumber;
    private String taskId;
    public LoopTaskB(){
        this.instanceNumber = ++count;
        this.taskId = "LoopTaskB " + instanceNumber;
    }
    @Override
    public void run(){
        String currentThread = Thread.currentThread().getName();
        System.out.println("##### [" + currentThread + "] " + taskId +" STARTING #####");
        for(int i=10;i>0;i--){
            System.out.println("[" + currentThread + "] <"+ taskId +">TICK TICK - " + i);
            try {
                TimeUnit.MILLISECONDS.sleep(250);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("***** [" + currentThread + "] "+ taskId +"> COMPLETED *****");
    }

}


