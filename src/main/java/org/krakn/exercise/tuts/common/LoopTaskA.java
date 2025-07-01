package org.krakn.exercise.tuts.common;

import java.util.concurrent.TimeUnit;

 public class LoopTaskA implements Runnable{
    private static int count = 0;
    private int id;
    public LoopTaskA(){
        this.id = ++count;

    }
    @Override
    public void run(){
        System.out.println("##### <TASK-"+id+"> STARTING #####");
        for(int i=10;i>0;i--){
            System.out.println("<"+id+">TICK TICK - " + i);
            try {
                TimeUnit.MILLISECONDS.sleep(250);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("***** <TASK-"+id+"> COMPLETED *****");
    }

}

