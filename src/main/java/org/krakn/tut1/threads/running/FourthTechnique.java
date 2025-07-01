package org.krakn.tut1.threads.running;

import java.util.concurrent.TimeUnit;

public class FourthTechnique {
    public static void main(String[] args) {
        System.out.println("Main Thread starts here...");
        new Thread(new FourthTask()).start();
        Thread t = new Thread(new FourthTask());
        t.start();
        System.out.println("Main Thread ends here...");
    }
}
class FourthTask implements Runnable{
    private static int count = 0;
    private int id;
    public FourthTask(){
        this.id = ++count;

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


