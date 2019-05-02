package com.nrslib.clArc.inject;

public interface ServiceCollection {
    <T> void addTransient(Class<T> clazz);
    <T, TInstance extends T> void addTransient(Class<T> clazzFrom, Class<TInstance> clazzTo);
    <T> void addSingleton(Class<T> clazz);
    <T, TInstance extends T> void addInstance(Class<T> clazz, TInstance instance);
    ServiceProvider buildServiceProvider();
}
