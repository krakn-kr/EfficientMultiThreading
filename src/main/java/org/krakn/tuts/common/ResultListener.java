package org.krakn.tuts.common;

public interface ResultListener<T> {
    void notifyResult(T result);
}
