package org.krakn.tut2.threads.naming;

import org.krakn.tuts.common.LoopTaskB;
import org.krakn.tuts.common.LoopTaskC;

public class NamingThreadsSecondTechnique {
    public static void main(String[] args) {
        System.out.println("Main thread starts here...");
        new Thread(new LoopTaskC(),"worker-1").start();
        Thread t = new Thread(new LoopTaskC());

        t.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t.setName("worker-2");
        System.out.println("Main thread ends here...");
    }
}
