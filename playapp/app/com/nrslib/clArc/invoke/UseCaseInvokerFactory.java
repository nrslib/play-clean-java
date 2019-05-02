package com.nrslib.clArc.invoke;

import com.nrslib.clArc.inject.ServiceProvider;

public interface UseCaseInvokerFactory {
    UseCaseInvoker generate(Class implementClazz, ServiceProvider provider);
}
