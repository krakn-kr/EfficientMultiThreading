package org.krakn.tut3;

import org.krakn.tuts.common.ResultListener;

public class SumObserver implements ResultListener<Integer> {
    private String taskId;

    public SumObserver(String taskId) {
        this.taskId = taskId;
    }

    @Override
    public void notifyResult(Integer result) {
        System.out.println("Result for " + taskId + " = " + result);
    }
}
