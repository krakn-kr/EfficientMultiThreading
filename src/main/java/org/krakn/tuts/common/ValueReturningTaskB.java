package org.krakn.tuts.common;

import java.util.concurrent.TimeUnit;

public class ValueReturningTaskB implements Runnable{
    private int a;
    private int b;
    private long sleepTime;
    private int sum = 0;

    private static int count = 0;
    private int instanceNumber;
    private String taskId;

    private ResultListener<Integer> resultProcessor;
    public ValueReturningTaskB(int a, int b, long sleepTime,ResultListener<Integer> resultProcessor) {
        this.a = a;
        this.b = b;
        this.sleepTime = sleepTime;
        this.instanceNumber = ++count;
        this.taskId = "ValueReturningTaskA-" + instanceNumber;
        this.resultProcessor = resultProcessor;
    }

    @Override
    public void run() {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("##### [" + currentThreadName + "] <" + taskId + "> STARTING ##### ");

        try {
            TimeUnit.MILLISECONDS.sleep(sleepTime);
            sum = a + b;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("##### [" + currentThreadName + "] <" + taskId + ">CALCULATION COMPLETED ##### ");
        resultProcessor.notifyResult(sum);
    }
}
