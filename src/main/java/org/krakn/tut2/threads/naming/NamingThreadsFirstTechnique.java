package org.krakn.tut2.threads.naming;

import org.krakn.tuts.common.LoopTaskB;

public class NamingThreadsFirstTechnique {
    public static void main(String[] args) {
        System.out.println("Main thread starts here...");
        new Thread(new LoopTaskB()).start();
        Thread t = new Thread(new LoopTaskB());
        t.start();
        System.out.println("Main thread ends here...");
    }
}
