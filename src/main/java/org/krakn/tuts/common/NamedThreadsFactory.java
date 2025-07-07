package org.krakn.tuts.common;

import java.util.concurrent.ThreadFactory;

public class NamedThreadsFactory implements ThreadFactory {
    private static int count = 0;
    private static String Name = "PoolWorker-";
    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, Name + ++count);
    }
}
