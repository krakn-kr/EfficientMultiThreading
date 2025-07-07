package org.krakn.tuts.common;

import java.util.concurrent.TimeUnit;

public class ValueReturningTaskA implements Runnable{
    private int a;
    private int b;
    private long sleepTime;
    private int sum = 0;

    private static int count = 0;
    private int instanceNumber;
    private String taskId;
    private volatile boolean done = false;
    public ValueReturningTaskA(int a, int b, long sleepTime) {
        this.a = a;
        this.b = b;
        this.sleepTime = sleepTime;
        this.instanceNumber = ++count;
        this.taskId = "ValueReturningTaskA-" + instanceNumber;
    }

    @Override
    public void run() {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("##### [" + currentThreadName + "] <" + taskId + "> STARTED ##### ");

            try {
                TimeUnit.MILLISECONDS.sleep(sleepTime);
                sum = a + b;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            done = true;
        synchronized (this){
            System.out.println("[" + currentThreadName + "] <" + taskId +
                    "> NOTIFYING ...");
                this.notify();
        }
        System.out.println("##### [" + currentThreadName + "] <" + taskId + "> COMPLETED ##### ");

    }

    public int getSum() {
        synchronized (this){
            if(!done){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return sum;
    }
}
