package com.nrslib.clArc.inject;

public interface ServiceProvider {
    <T> T getService(Class<T> type);
}
