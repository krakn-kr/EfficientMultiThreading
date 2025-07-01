package org.krakn.tut1.threads.running;

import java.util.concurrent.TimeUnit;

public class FirstTechnique {
    public static void main(String[] args) {
        System.out.println("Main Thread starts here...");
        new FirstTask();
        new FirstTask();
        System.out.println("Main Thread ends here...");
    }
}
class FirstTask extends Thread{
    private static int count = 0;
    private int id;
    public FirstTask(){
        this.id = ++count;
        this.start();
    }
    @Override
    public void run(){
        for(int i=10;i>0;i--){
            System.out.println("<"+id+">Tick Tick - " + i);
            try {
                TimeUnit.MILLISECONDS.sleep(250);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
